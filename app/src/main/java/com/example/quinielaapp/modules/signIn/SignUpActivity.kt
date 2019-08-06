package com.example.quinielaapp.modules.signIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quinielaapp.DashboardActivity
import com.example.quinielaapp.R

class SignUpActivity : AppCompatActivity() {

    var signUpButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpButton = findViewById(R.id.signup_button)

        signUpButton?.setOnClickListener {
            val intent = Intent(baseContext, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}
