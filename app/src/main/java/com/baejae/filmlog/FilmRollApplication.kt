package com.baejae.filmlog

import android.app.Application
import com.baejae.filmlog.data.database.AppDatabase
import com.baejae.filmlog.data.database.FilmRollRepository

class FilmRollApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
    val filmRollRepository by lazy { FilmRollRepository(db.filmRollDao()) }
}