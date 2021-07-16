package com.baejae.filmlog.data.database

import androidx.room.*
import com.baejae.filmlog.data.model.Picture

@Dao
interface PictureDao {
    @Query("SELECT * FROM picture")
    fun get(): List<Picture>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(picture: Picture)

    @Delete
    fun delete(picture: Picture)
}