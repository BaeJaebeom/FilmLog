package com.baejae.filmlog.data.database

import androidx.room.*

@Dao
interface FocalLengthDao {
    @Query("SELECT * FROM focal_length")
    fun get(): List<FocalLength>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(focalLength: FocalLength)

    @Delete
    fun delete(focalLength: FocalLength)
}