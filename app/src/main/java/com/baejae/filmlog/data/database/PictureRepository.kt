package com.baejae.filmlog.data.database

import com.baejae.filmlog.data.model.Picture

class PictureRepository constructor(private val pictureDao: PictureDao) {

    fun getAll(): List<Picture> = pictureDao.get()

    fun insert(picture: Picture){
//        picture.createDate = SimpleDateFormat("yyyy-MM-dd HH:mm",
//            Locale.getDefault()).format(Date())
        Thread(Runnable {
            pictureDao.insert(picture)
        })
    }

    fun delete(picture: Picture){
        Thread(Runnable {
            pictureDao.delete(picture)
        })
    }

}