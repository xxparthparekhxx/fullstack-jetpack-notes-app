package com.krish.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.krish.myapplication.util.Constants.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var title : String,
    var description : String,
    var priority : String
)
