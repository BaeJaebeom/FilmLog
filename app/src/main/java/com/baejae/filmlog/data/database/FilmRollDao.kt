package com.baejae.filmlog.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.baejae.filmlog.data.model.FilmRoll

@Dao
interface FilmRollDao {
    @Query("SELECT * FROM film_roll")
    fun get(): LiveData<List<FilmRoll>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(filmRoll: FilmRoll)

    @Delete
    fun delete(filmRoll: FilmRoll)
}