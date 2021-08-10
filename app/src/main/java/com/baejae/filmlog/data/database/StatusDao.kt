package com.baejae.filmlog.data.database

import androidx.room.*

@Dao
interface StatusDao {
    @Query("SELECT * FROM status")
    fun get(): List<Status>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(status: Status)

    @Delete
    fun delete(status: Status)
}