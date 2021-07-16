package com.baejae.filmlog.data.database

import androidx.room.*
import com.baejae.filmlog.data.model.FocalLength

@Dao
interface FocalLengthDao {
    @Query("SELECT * FROM focal_length")
    fun get(): List<FocalLength>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(focalLength: FocalLength)

    @Delete
    fun delete(focalLength: FocalLength)
}