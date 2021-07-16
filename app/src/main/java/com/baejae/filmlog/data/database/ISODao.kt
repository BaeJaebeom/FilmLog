package com.baejae.filmlog.data.database

import androidx.room.*
import com.baejae.filmlog.data.model.ISO

@Dao
interface ISODao {
    @Query("SELECT * FROM iso")
    fun get(): List<ISO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(iso: ISO)

    @Delete
    fun delete(iso: ISO)
}