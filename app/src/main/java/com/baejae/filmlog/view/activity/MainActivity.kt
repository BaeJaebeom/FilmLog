package com.baejae.filmlog.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.baejae.filmlog.R
import com.baejae.filmlog.data.database.AppDatabase
import com.baejae.filmlog.data.model.FilmRoll
import com.baejae.filmlog.databinding.ActivityMainBinding
import com.baejae.filmlog.view.adapter.FilmRollAdapter
import com.baejae.filmlog.view.viewmodel.FilmRollViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var filmRollViewModel: FilmRollViewModel
    private lateinit var filmRollAdapter: FilmRollAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO : sharedpreferences 만들기
        //뷰바인딩 세팅
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        //FilmRoll 어댑터 세팅
        filmRollAdapter = FilmRollAdapter()
        filmRollAdapter.onItemClick = {
            //TODO : 애니메이션 적용해서 새 창 띄우기
            //TODO : 새 창 띄운거에 하단 바 만들기
        }
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        viewBinding.mainFilmRollRecyclerView.layoutManager = linearLayoutManager
        viewBinding.mainFilmRollRecyclerView.setHasFixedSize(true)
        viewBinding.mainFilmRollRecyclerView.adapter = filmRollAdapter

        //뷰모델 세팅
        filmRollViewModel = ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(FilmRollViewModel::class.java)
        filmRollViewModel.getFilmRollList()
            .observe(this, {
                it?.let { filmRollAdapter.setContacts(it) }
            })

        // recyclerView

//        val filmRoll = FilmRoll(
//            id = null,
//            status = "a",
//            name = "b",
//            comment = "v",
//            createDate = SimpleDateFormat("yyyy-MM-dd HH:mm",
//                Locale.getDefault()).format(Date()),
//            camera = "d",
//            film = "e",
//            format = "f",
//            defaultLens = "g",
//            defaultFocalLength = "h",
//            defaultBoxISO = 10,
//            defaultRatedISO = 100,
//            defaultShutterSpeed = "",
//            defaultAperture = 1000
//        )
//        filmRollViewModel.insert(filmRoll)

        //TODO : 애니메이션 적용해서 필름 추가 창 띄우기
        viewBinding.mainBottomAppBar.setNavigationOnClickListener {

        }

        //TODO : 정렬 순서 바꾸는 코드 작성
        viewBinding.mainBottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.mainAppBarSortGroupOldest, R.id.mainAppBarSortGroupLatest -> {
                    menuItem.isChecked = !menuItem.isChecked
                    true
                }
//                R.id.mainAppBarMoreOptionCreateBackup -> {
//                    // Handle more item (inside overflow menu) press
//                    true
//                }
//                R.id.mainAppBarMoreOptionRestoreBackup-> {
//                    // Handle more item (inside overflow menu) press
//                    true
//                }
//                R.id.mainAppBarMoreOptionSupport -> {
//                    // Handle more item (inside overflow menu) press
//                    true
//                }
                else -> false
            }
        }

        val multiItems = arrayOf(
            resources.getString(R.string.status_active),
            resources.getString(R.string.status_processed),
            resources.getString(R.string.status_digitised),
            resources.getString(R.string.status_printed),
            resources.getString(R.string.status_archived))
        //TODO : sharedpreferences에서 값 가져와서 checkedItems 만들기
        val checkedItems = booleanArrayOf(true, true, true, true, true, false)
        val mainAppBarFilter : View = findViewById(R.id.mainAppBarWorkflowFilter)
        mainAppBarFilter.setOnClickListener {
            MaterialAlertDialogBuilder(this@MainActivity)
                .setTitle(resources.getString(R.string.main_app_bar_workflow_filter_title))
                .setNeutralButton(resources.getString(R.string.main_app_bar_workflow_filter_all)) { dialog, which ->
                    // Respond to neutral button press
                }
                .setNegativeButton(resources.getString(R.string.main_app_bar_workflow_filter_cancel)) { dialog, which ->
                    // Respond to negative button press
                }
                .setPositiveButton(resources.getString(R.string.main_app_bar_workflow_filter_accept)) { dialog, which ->
                    // Respond to positive button press
                }
                .setMultiChoiceItems(multiItems, checkedItems) { dialog, which, checked ->
                    // Respond to item chosen
                }
                .show()
        }

    }
}