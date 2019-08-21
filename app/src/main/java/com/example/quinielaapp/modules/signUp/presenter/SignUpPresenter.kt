package com.example.quinielaapp.modules.signUp.presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.quinielaapp.BuildConfig
import com.example.quinielaapp.DashboardActivity
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import com.wajahatkarim3.easyvalidation.core.view_ktx.validNumber

class SignUpPresenter(private val view: Activity, private val delegate: OnSignUpEvent){

    fun validateFields(name: String, userName: String, email: String, phone: String, password: String){
        if (!phone.validNumber()){
            delegate.onInvalidphone()
        }
        if (!email.validEmail()){
            delegate.onInvalidphone()
        }

        if (phone.validNumber() && email.validNumber()){
            setRolInSharedPreferences()
            val intent = Intent(view.baseContext, DashboardActivity::class.java)
            view.startActivity(intent)
        }
    }

    fun setRolInSharedPreferences(){
        val editor = view.getSharedPreferences(BuildConfig.MY_PREFS_NAME, Context.MODE_PRIVATE).edit()
        editor.putInt("rol", 1)
        editor.apply()
    }

    interface OnSignUpEvent{
        fun onInvalidUserName()
        fun onInvalidEmail()
        fun onInvalidphone()
    }
}