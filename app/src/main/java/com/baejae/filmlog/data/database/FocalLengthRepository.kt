package com.baejae.filmlog.data.database

class FocalLengthRepository constructor(private val focalLengthDao: FocalLengthDao){

    fun getAll() : List<FocalLength> = focalLengthDao.get()

    fun insert(focalLength: FocalLength){
        Thread(Runnable {
            focalLengthDao.insert(focalLength)
        }).start()
    }

    fun delete(focalLength: FocalLength){
        Thread(Runnable {
            focalLengthDao.delete(focalLength)
        }).start()
    }
}