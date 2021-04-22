package com.example.atividade05

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var txtLogin: EditText? = null
    private var txtSenha: EditText? = null
    private var btLogin: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtLogin = findViewById(R.id.txtLogin)
        txtSenha = findViewById(R.id.txtSenha)
        btLogin = findViewById(R.id.btLogin)

        //view.findViewById<Button>(R.id.btLogin).setOnClickListener(this)

        //btLogin.setOnClickListener {this}
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        view.findViewById<Button>(R.id.btLogin).setOnClickListener(this)
//    }


    private fun validaLogin(login: String, senha: String): Boolean {
        return login == "Julia" && senha == "5565"
    }

    override fun onClick(view: View) {
        val login = txtLogin!!.text.toString()
        val senha = txtSenha!!.text.toString()
        val loginValido = validaLogin(login, senha)
        val mensagem = "Login " + if (loginValido) "VÁLIDO" else "INVÁLIDO"
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }
}