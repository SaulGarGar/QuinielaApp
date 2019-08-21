package com.example.quinielaapp.modules.logIn.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.quinielaapp.R
import com.example.quinielaapp.modules.logIn.presenter.LogInPresenter
import com.example.quinielaapp.modules.signUp.views.SignUpActivity
import com.google.android.material.button.MaterialButton

class LogInActivity : AppCompatActivity(), LogInPresenter.OnLoginEvent {

    private lateinit var signUpTextView: TextView

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    private lateinit var loginButton: MaterialButton

    private lateinit var presenter: LogInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        initData()
        initViews()
        onClikEvents()
    }

    fun initData(){
        presenter = LogInPresenter(this, this)
    }

    fun initViews(){
        signUpTextView = findViewById(R.id.signup_text_view)
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)
    }

    fun onClikEvents(){
        signUpTextView.setOnClickListener {
            val intent = Intent(baseContext, SignUpActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            presenter.validateData(emailEditText.text.toString(),passwordEditText.text.toString())
        }
    }

    override fun onInvalidData(dataType: LogInPresenter.InvalidDataType) {
        if (dataType == LogInPresenter.InvalidDataType.EMAIL){
            emailEditText.error = getString(R.string.invalid_mail)
        }
    }
}
