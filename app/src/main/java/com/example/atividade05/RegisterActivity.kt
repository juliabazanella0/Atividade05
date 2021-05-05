package com.example.atividade05

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.atividade05.adapters.PersonAdapter
import com.example.atividade05.database.AppDatabase
import com.example.atividade05.database.daos.PersonDAO
import com.example.atividade05.models.Person
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var dao: PersonDAO

    fun createDB() {
        // Create DB instance
        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "person-db"
        )
            .allowMainThreadQueries()
            .build()


        // Get DAO
        dao = db.personDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        createDB()

        btnRegister.setOnClickListener {

            val username = editUsername.text.trim().toString()
            val password = editPassword.text.trim().toString()

            if (username.isNotEmpty() || password.isNotEmpty()) {
                val person = Person(username, password)
                add(person)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Dados para Registro Inválidos", Toast.LENGTH_LONG).show()
            }
        }
        tvLogin.setOnClickListener {
            finish()
        }
    }

    fun add(person: Person) {
        person.id = dao.insert(person)
    }
}