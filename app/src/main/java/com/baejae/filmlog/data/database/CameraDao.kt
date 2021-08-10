package com.baejae.filmlog.data.database

import androidx.room.*

@Dao
interface CameraDao {
    @Query("SELECT * FROM camera")
    fun get(): List<Camera>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(camera: Camera)

    @Delete
    fun delete(camera: Camera)
}