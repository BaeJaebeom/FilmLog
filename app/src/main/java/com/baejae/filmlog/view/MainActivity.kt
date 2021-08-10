package com.baejae.filmlog.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.baejae.filmlog.FilmRollApplication
import com.baejae.filmlog.R
import com.baejae.filmlog.data.database.FilmRoll
import com.baejae.filmlog.data.database.FilmRollRepository
import com.baejae.filmlog.databinding.ActivityMainBinding
import com.baejae.filmlog.view.filmroll.FilmRollAdapter
import com.baejae.filmlog.view.filmroll.FilmRollViewModel
import com.baejae.filmlog.view.filmroll.FilmRollViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private val filmRollViewModel: FilmRollViewModel by viewModels{
        FilmRollViewModelFactory((application as FilmRollApplication).filmRollRepository)
    }
//    private lateinit var filmRollViewModel: FilmRollViewModel
    private lateinit var filmRollAdapter: FilmRollAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰바인딩 세팅
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        //TODO : sharedpreferences 만들기

        //뷰모델 세팅
//        filmRollViewModel = ViewModelProvider(this
//        ).get(FilmRollViewModel((application as FilmRollApplication).filmRollRepository)::class.java)


        filmRollViewModel.getFilmRollList()
            .observe(this, {
                it?.let { filmRollAdapter.setContacts(it) }
            })

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

        // recyclerView

//        val filmRoll = FilmRoll(
//            id = null,
//            status = "Active",
//            name = "대구광역시, 22일 7월 2021",
//            comment = "test",
//            createDate = SimpleDateFormat("yyyy-MM-dd HH:mm",
//                Locale.getDefault()).format(Date()),
//            camera = "Nikon FE",
//            film = "Kodak Gold 200",
//            format = "test",
//            defaultLens = "test",
//            defaultFocalLength = "test",
//            defaultBoxISO = 10,
//            defaultRatedISO = 10,
//            defaultShutterSpeed = "test",
//            defaultAperture = 10
//        )
//        filmRollViewModel.insert(filmRoll)
//        filmRollViewModel.insert(filmRoll)
//        filmRollViewModel.insert(filmRoll)
//        filmRollViewModel.insert(filmRoll)
//        filmRollViewModel.insert(filmRoll)

        //TODO : 애니메이션 적용해서 필름 추가 창 띄우기
        viewBinding.mainBottomAppBarFloatingActionButton.setOnClickListener {

        }


        //TODO : 정렬 순서 바꾸는 코드 작성
        viewBinding.mainBottomAppBar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.mainAppBarSortGroupOldest, R.id.mainAppBarSortGroupLatest -> {
                    item.isChecked = !item.isChecked
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
            resources.getString(R.string.status_archived)
        )
        //TODO : sharedpreferences에서 값 가져와서 checkedItems 만들기
        val checkedItems = booleanArrayOf(true, true, true, true, true, false)
        val mainAppBarFilter: View = findViewById(R.id.mainAppBarWorkflowFilter)
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

    //TODO : Edit창 만들고 Edit 추가하기
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val filmRoll: FilmRoll = filmRollAdapter.filmRollList[filmRollAdapter.getPosition()]
        when (item.itemId) {
            R.id.filmRollAdapterMenuEdit -> {

            }
            R.id.filmRollAdapterMenuDelete -> {
                filmRollViewModel.delete(filmRoll)
            }
            R.id.filmRollAdapterMenuWorkflowActive -> {
                item.isChecked = true
                filmRollViewModel.updateStatus(
                    filmRoll,
                    resources.getString(R.string.status_active)
                )
            }
            R.id.filmRollAdapterMenuWorkflowProcessed -> {
                item.isChecked = true
                filmRollViewModel.updateStatus(
                    filmRoll,
                    resources.getString(R.string.status_processed)
                )
            }
            R.id.filmRollAdapterMenuWorkflowDigitised -> {
                item.isChecked = true
                filmRollViewModel.updateStatus(
                    filmRoll,
                    resources.getString(R.string.status_digitised)
                )
            }
            R.id.filmRollAdapterMenuWorkflowPrinted -> {
                item.isChecked = true
                filmRollViewModel.updateStatus(
                    filmRoll,
                    resources.getString(R.string.status_printed)
                )
            }
            R.id.filmRollAdapterMenuWorkflowArchived -> {
                item.isChecked = true
                filmRollViewModel.updateStatus(
                    filmRoll,
                    resources.getString(R.string.status_archived)
                )
            }
        }
        return true
    }
}