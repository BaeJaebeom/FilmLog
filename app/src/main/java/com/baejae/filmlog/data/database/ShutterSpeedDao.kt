package com.baejae.filmlog.data.database

import androidx.room.*
import com.baejae.filmlog.data.model.ShutterSpeed

@Dao
interface ShutterSpeedDao {
    @Query("SELECT * FROM shutter_speed")
    fun get(): List<ShutterSpeed>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(shutterSpeed: ShutterSpeed)

    @Delete
    fun delete(shutterSpeed: ShutterSpeed)
}