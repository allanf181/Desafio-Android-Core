package com.allan.desafioandroidcore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button_register.setOnClickListener {
            val i = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(i)
        }
        button_login.setOnClickListener {
            val i = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}