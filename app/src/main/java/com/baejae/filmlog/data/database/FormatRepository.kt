package com.baejae.filmlog.data.database

class FormatRepository constructor(private val formatDao: FormatDao){

    fun getAll() : List<Format> = formatDao.get()

    fun insert(format: Format){
        Thread(Runnable {
            formatDao.insert(format)
        }).start()
    }

    fun delete(format: Format){
        Thread(Runnable {
            formatDao.delete(format)
        }).start()
    }
}