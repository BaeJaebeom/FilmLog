package com.baejae.filmlog.data.database

import androidx.lifecycle.LiveData
import com.baejae.filmlog.data.model.FilmRoll

class FilmRollRepository constructor(private val filmRollDao: FilmRollDao) {

    fun getAll(): LiveData<List<FilmRoll>> = filmRollDao.get()

    fun insert(filmRoll: FilmRoll){
//        filmRoll.createDate = SimpleDateFormat("yyyy-MM-dd HH:mm",
//            Locale.getDefault()).format(Date())
        Thread {
            filmRollDao.insert(filmRoll)
        }.start()
    }

    fun delete(filmRoll: FilmRoll){
        Thread {
            filmRollDao.delete(filmRoll)
        }.start()
    }

}