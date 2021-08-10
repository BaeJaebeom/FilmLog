package com.baejae.filmlog.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shutter_speed")
data class ShutterSpeed (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long,

    @ColumnInfo(name = "value")
    var value: String
)