package com.baejae.filmlog.data.database

import com.baejae.filmlog.data.model.ShutterSpeed

class ShutterSpeedRepository constructor(private val shutterSpeedDao: ShutterSpeedDao){

    fun getAll() : List<ShutterSpeed> = shutterSpeedDao.get()

    fun insert(shutterSpeed: ShutterSpeed){
        Thread(Runnable {
            shutterSpeedDao.insert(shutterSpeed)
        }).start()
    }

    fun delete(shutterSpeed: ShutterSpeed){
        Thread(Runnable {
            shutterSpeedDao.delete(shutterSpeed)
        }).start()
    }
}