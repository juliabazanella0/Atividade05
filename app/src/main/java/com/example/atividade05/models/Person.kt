package com.example.atividade05.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class Person (
    var username: String,
    var password: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}