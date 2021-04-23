package com.example.atividade05

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.* // Nessa linha a gente usa o plugin instalado pra inflar a main activity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener { login() }
    }

    private fun login() {
        var login = txtLogin.text.toString()
        var senha = txtSenha.text.toString()

        if(!validaLogin(login, senha)) {
            Toast.makeText(this, "Dados Inválidos", Toast.LENGTH_SHORT).show()
            return;
        }

        val mainIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(mainIntent)
    }

    private fun validaLogin(login: String, senha: String): Boolean {
        return login == "Julia" && senha == "5565"
    }
}