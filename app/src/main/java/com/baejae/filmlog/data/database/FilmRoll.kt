package com.baejae.filmlog.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "film_roll")
data class FilmRoll(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "comment")
    var comment: String,

    @ColumnInfo(name = "create_date", defaultValue = "CURRENT_TIMESTAMP")
    var createDate: Timestamp,

    @ColumnInfo(name = "camera")
    var camera: String,

    @ColumnInfo(name = "film")
    var film: String,

    @ColumnInfo(name = "format")
    var format: String,

    @ColumnInfo(name = "default_lens")
    var defaultLens: String,

    @ColumnInfo(name = "default_focal_length")
    var defaultFocalLength: String,

    @ColumnInfo(name = "default_box_iso")
    var defaultBoxISO: Int,

    @ColumnInfo(name = "default_rated_iso")
    var defaultRatedISO: Int,

    @ColumnInfo(name = "default_shutter_speed")
    var defaultShutterSpeed: String,

    @ColumnInfo(name = "default_aperture")
    var defaultAperture: Int
)