package com.example.quinielaapp.modules.signUp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.quinielaapp.DashboardActivity
import com.example.quinielaapp.R
import com.example.quinielaapp.modules.signUp.presenter.SignUpPresenter

class SignUpActivity : AppCompatActivity(), SignUpPresenter.OnSignUpEvent {

    private lateinit var signUpButton: Button
    private lateinit var presenter: SignUpPresenter

    private lateinit var nameEditText: EditText
    private lateinit var userNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initData()
        initViews()
        onClickEvents()
    }

    fun initData(){
        presenter = SignUpPresenter(this,this)
    }

    fun initViews(){
        signUpButton = findViewById(R.id.signup_button)

        nameEditText = findViewById(R.id.name_edit_text)
        userNameEditText = findViewById(R.id.user_name_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        phoneEditText = findViewById(R.id.phone_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
    }

    fun onClickEvents(){
        signUpButton.setOnClickListener {
            presenter.validateFields(nameEditText.text.toString(),userNameEditText.text.toString(),emailEditText.text.toString(),phoneEditText.text.toString(),passwordEditText.text.toString())
        }
    }

    override fun onInvalidUserName() {
        userNameEditText.error = getString(R.string.user_name_taked)
    }

    override fun onInvalidEmail() {
        emailEditText.error = getString(R.string.invalid_mail)
    }

    override fun onInvalidphone() {
        phoneEditText.error = getString(R.string.invalid_phone)
    }
}
