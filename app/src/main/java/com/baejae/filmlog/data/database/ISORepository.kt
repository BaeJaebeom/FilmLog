package com.baejae.filmlog.data.database

class ISORepository constructor(private val isoDao: ISODao){

    fun getAll() : List<ISO> = isoDao.get()

    fun insert(iso: ISO){
        Thread(Runnable {
            isoDao.insert(iso)
        }).start()
    }

    fun delete(iso: ISO){
        Thread(Runnable {
            isoDao.delete(iso)
        }).start()
    }
}