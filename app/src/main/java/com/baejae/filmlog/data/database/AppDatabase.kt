package com.baejae.filmlog.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.baejae.filmlog.util.DATABASE_NAME

@Database(entities = [Aperture::class, Camera::class, Film::class, FilmRoll::class,
    FocalLength::class, Format::class, ISO::class, Picture::class, ShutterSpeed::class,
    Status::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun apertureDao(): ApertureDao

    private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase =
        instance ?: synchronized(this){
            instance?: buildDatabase(context).also { instance = it }
        }

    private fun buildDatabase(context: Context) =
        Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java, DATABASE_NAME
        )
                // db 미리채우기 https://developer.android.com/training/data-storage/room/prepopulate?hl=ko
//            .createFromFile()
            .build()
}