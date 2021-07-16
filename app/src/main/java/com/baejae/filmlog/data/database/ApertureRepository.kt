package com.baejae.filmlog.data.database;

import com.baejae.filmlog.data.model.Aperture

class ApertureRepository constructor(private val apertureDao: ApertureDao){

    fun getAll(): List<Aperture> = apertureDao.get()

    fun insert(aperture: Aperture){
        Thread(Runnable {
            apertureDao.insert(aperture)
        }).start()
    }

    fun delete(aperture: Aperture){
        Thread(Runnable {
            apertureDao.delete(aperture)
        }).start()
    }
}
