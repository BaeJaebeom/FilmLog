package com.baejae.filmlog.data.database

import androidx.lifecycle.LiveData

class FilmRollRepository constructor(private val filmRollDao: FilmRollDao) {

    fun getAll(): LiveData<List<FilmRoll>> = filmRollDao.get()

    fun getFromStatus(statusList: List<String>): LiveData<List<FilmRoll>> =
        filmRollDao.getFromStatus(statusList)

    fun insert(filmRoll: FilmRoll){
        Thread {
            filmRollDao.insert(filmRoll)
        }.start()
    }

    fun delete(filmRoll: FilmRoll){
        Thread {
            filmRollDao.delete(filmRoll)
        }.start()
    }

    fun update(filmRoll: FilmRoll){
        Thread {
            filmRollDao.update(filmRoll)
        }.start()
    }

}