package com.example.quinielaapp.modules.logIn.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.quinielaapp.R
import com.example.quinielaapp.modules.signIn.SignUpActivity

class LogInActivity : AppCompatActivity() {

    private var SignUpTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        initViews()
    }

    fun initViews(){
        SignUpTextView = findViewById(R.id.signup_text_view)

        SignUpTextView?.setOnClickListener {
            val intent = Intent(baseContext, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
