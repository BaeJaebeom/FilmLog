package com.baejae.filmlog.view.filmroll

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.baejae.filmlog.FilmRollApplication
import com.baejae.filmlog.R

class FilmRollFragment : Fragment() {

    companion object {
        fun newInstance() = FilmRollFragment()
    }

    private val filmRollViewModel: FilmRollViewModel by viewModels{
        FilmRollViewModelFactory((requireActivity().application as FilmRollApplication)
            .filmRollRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.film_roll_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(FilmRollViewModel::class.java)
        // TODO: Use the ViewModel
    }

}