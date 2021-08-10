package com.baejae.filmlog.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "picture")
data class Picture (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long?,

    @ColumnInfo(name = "film_roll_id")
    var filmRollId: Long,

    @ColumnInfo(name = "comment")
    var comment: String,

    @ColumnInfo(name = "create_date", defaultValue = "CURRENT_TIMESTAMP")
    var createDate: String?,

    @ColumnInfo(name = "focal_length")
    var focalLength: Int,

    @ColumnInfo(name = "box_iso")
    var boxISO: Int,

    @ColumnInfo(name = "rated_iso")
    var ratedISO: Int,

    @ColumnInfo(name = "shutter_speed")
    var shutterSpeed: String,

    @ColumnInfo(name = "aperture")
    var aperture: Int,

    @ColumnInfo(name = "latitude")
    var latitude: Float,

    @ColumnInfo(name = "longitude")
    var longitude: Float,

    @ColumnInfo(name = "locality")
    var locality: String
)