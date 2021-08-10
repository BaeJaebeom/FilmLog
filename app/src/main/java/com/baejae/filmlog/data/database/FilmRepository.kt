package com.baejae.filmlog.data.database

class FilmRepository constructor(private val filmDao: FilmDao){

    fun getAll() : List<Film> = filmDao.get()

    fun insert(film: Film){
        Thread(Runnable {
            filmDao.insert(film)
        }).start()
    }

    fun delete(film: Film){
        Thread(Runnable {
            filmDao.delete(film)
        }).start()
    }
}