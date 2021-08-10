package com.baejae.filmlog.view.filmroll

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.baejae.filmlog.data.database.FilmRollRepository
import com.baejae.filmlog.data.database.FilmRoll

class FilmRollViewModel(private val filmRollRepository: FilmRollRepository) : ViewModel() {

    private val filmRollList: LiveData<List<FilmRoll>> = filmRollRepository.getAll()

//    init{
//        val filmRollDao = AppDatabase.getInstance(application).filmRollDao()
//        filmRollRepository = FilmRollRepository(filmRollDao)
//    }

    fun insert(filmRoll: FilmRoll) = filmRollRepository.insert(filmRoll)

    fun delete(filmRoll: FilmRoll) = filmRollRepository.delete(filmRoll)

    fun getFilmRollList(): LiveData<List<FilmRoll>> {
        return filmRollList
    }

    fun updateStatus(filmRoll: FilmRoll, status: String) {
        filmRoll.status = status
        filmRollRepository.update(filmRoll)
    }
}

class FilmRollViewModelFactory(private val repository: FilmRollRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilmRollViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FilmRollViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}