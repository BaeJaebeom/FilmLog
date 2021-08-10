package com.baejae.filmlog.data.database

class CameraRepository constructor(private val cameraDao: CameraDao){

    fun getAll() : List<Camera> = cameraDao.get()

    fun insert(camera: Camera){
        Thread(Runnable {
            cameraDao.insert(camera)
        }).start()
    }

    fun delete(camera: Camera){
        Thread(Runnable {
            cameraDao.delete(camera)
        }).start()
    }
}