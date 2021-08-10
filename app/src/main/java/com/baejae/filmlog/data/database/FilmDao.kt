package com.baejae.filmlog.data.database

import androidx.room.*

@Dao
interface FilmDao {
    @Query("SELECT * FROM film")
    fun get(): List<Film>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(film: Film)

    @Delete
    fun delete(film: Film)
}