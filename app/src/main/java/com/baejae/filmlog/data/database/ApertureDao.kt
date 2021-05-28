package com.baejae.filmlog.data.database

import androidx.room.*

@Dao
interface ApertureDao {
    @Query("SELECT * FROM aperture")
    fun get(): List<Aperture>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(aperture: Aperture)

    @Delete
    fun delete(aperture: Aperture)
}
