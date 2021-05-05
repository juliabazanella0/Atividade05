package com.example.atividade05.database.daos

import androidx.room.*
import com.example.atividade05.models.Person

@Dao
interface PersonDAO {

    @Query(value = "SELECT * FROM people")
    fun getAll(): List<Person>

    @Query(value = "SELECT * FROM people WHERE id IN (:ids)")
    fun getAllByIds(ids: IntArray): List<Person>

    @Query(value = "SELECT * FROM people WHERE username = :username AND password = :password")
    fun findByName(username: String, password: String): Person

    @Insert
    fun insert(person: Person): Long

    @Insert
    fun insertAll(vararg people: Person): LongArray

    @Delete
    fun delete(person: Person)

    @Update
    fun update(person: Person)
}