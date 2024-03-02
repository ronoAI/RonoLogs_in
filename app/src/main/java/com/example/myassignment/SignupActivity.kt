package com.example.myassignment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        val usernameEditText: EditText = findViewById(R.id.unmEdit)
        val passwordEditText: EditText = findViewById(R.id.pwdEdit)
        val signupButton: Button = findViewById(R.id.sgnBtn)

        signupButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            editor.putString("username", username)
            editor.putString("password", password)
            editor.apply()

            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
            finish()
        }
    }
}
