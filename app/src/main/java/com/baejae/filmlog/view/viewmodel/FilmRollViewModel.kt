package com.baejae.filmlog.view.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.baejae.filmlog.data.database.AppDatabase
import com.baejae.filmlog.data.database.FilmRollRepository
import com.baejae.filmlog.data.model.FilmRoll

class FilmRollViewModel(application: Application) : AndroidViewModel(application) {
    private val filmRollRepository: FilmRollRepository
    private val filmRollList: LiveData<List<FilmRoll>>

    init{
        val filmRollDao = AppDatabase.getInstance(application).filmRollDao()
        filmRollRepository = FilmRollRepository(filmRollDao)
        filmRollList = filmRollRepository.getAll()
    }

    fun insert(filmRoll: FilmRoll) = filmRollRepository.insert(filmRoll)

    fun delete(filmRoll: FilmRoll) = filmRollRepository.delete(filmRoll)

    fun getFilmRollList(): LiveData<List<FilmRoll>> {
        return filmRollList
    }
}