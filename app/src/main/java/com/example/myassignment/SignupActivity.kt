package com.example.myassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignupActivity : AppCompatActivity() {

    private lateinit var loginHelper: LoginHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        loginHelper = LoginHelper(this)

        val usernameEditText: EditText = findViewById(R.id.unmEdit)
        val passwordEditText: EditText = findViewById(R.id.pwdEdit)
        val signupButton: Button = findViewById(R.id.sgnBtn)

        signupButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            loginHelper.insertUser(username, password)

            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
            finish()
        }
    }
}