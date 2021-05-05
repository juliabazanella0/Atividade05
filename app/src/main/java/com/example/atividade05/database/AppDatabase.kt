package com.example.atividade05.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.atividade05.database.daos.PersonDAO
import com.example.atividade05.models.Person

@Database(entities = [Person::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun personDao(): PersonDAO
}