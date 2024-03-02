package com.example.myassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var loginHelper: LoginHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginHelper = LoginHelper(this)

        val usernameEditText: EditText = findViewById(R.id.unmEdit)
        val passwordEditText: EditText = findViewById(R.id.pwdEdit)
        val loginButton: Button = findViewById(R.id.lgnBtn)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            val savedPassword = loginHelper.getUser(username)

            if (password == savedPassword) {
                // Successful login
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@LoginActivity, OpenActivity::class.java))
                finish()
            } else {
                // Failed login
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}