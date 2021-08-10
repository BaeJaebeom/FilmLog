package com.baejae.filmlog.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FilmRollDao {
    @Query("SELECT * FROM film_roll")
    fun get(): LiveData<List<FilmRoll>>

    @Query("SELECT * FROM film_roll WHERE status IN (:statusList)")
    fun getFromStatus(statusList: List<String>): LiveData<List<FilmRoll>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(filmRoll: FilmRoll)

    @Delete
    fun delete(filmRoll: FilmRoll)

    @Update
    fun update(filmRoll: FilmRoll)
}