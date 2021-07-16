package com.baejae.filmlog.data.database

import com.baejae.filmlog.data.model.Status

class StatusRepository constructor(private val statusDao: StatusDao){

    fun getAll() : List<Status> = statusDao.get()

    fun insert(status: Status){
        Thread(Runnable {
            statusDao.insert(status)
        }).start()
    }

    fun delete(status: Status){
        Thread(Runnable {
            statusDao.delete(status)
        }).start()
    }
}