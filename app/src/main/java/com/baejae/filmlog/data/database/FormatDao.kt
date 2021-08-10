package com.baejae.filmlog.data.database

import androidx.room.*

@Dao
interface FormatDao {
    @Query("SELECT * FROM format")
    fun get(): List<Format>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(format: Format)

    @Delete
    fun delete(format: Format)
}