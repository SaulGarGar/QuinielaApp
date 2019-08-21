package com.example.quinielaapp.modules.logIn.presenter

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.quinielaapp.DashboardActivity
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import android.content.Context.MODE_PRIVATE
import android.R.id.edit
import android.content.SharedPreferences
import com.example.quinielaapp.BuildConfig
import com.example.quinielaapp.modules.sellerAdminModules.searchUsers.views.SearchUsersActivity


class LogInPresenter(private val view: Activity, private val delegate: OnLoginEvent) {

    fun validateData(email: String, password: String){
        if (email.validEmail()){
            when(email){
                "user@gmail.com" -> {
                    val intent = Intent(view.baseContext, DashboardActivity::class.java)
                    setRolInSharedPreferences(1)
                    view.startActivity(intent)
                }
                "seller@gmail.com" -> {
                    val intent = Intent(view.baseContext, SearchUsersActivity::class.java)
                    setRolInSharedPreferences(2)
                    view.startActivity(intent)
                }
                "admin@gmail.com" -> {
                    val intent = Intent(view.baseContext, SearchUsersActivity::class.java)
                    setRolInSharedPreferences(3)
                    view.startActivity(intent)
                }
            }
        }
        else{
            delegate.onInvalidData(InvalidDataType.EMAIL)
        }
    }
    enum class InvalidDataType{
        EMAIL,
        PASSWORD
    }

    fun setRolInSharedPreferences(rol: Int){
        val editor = view.getSharedPreferences(BuildConfig.MY_PREFS_NAME, MODE_PRIVATE).edit()
        editor.putInt("rol", rol)
        editor.apply()
    }

    interface OnLoginEvent{
        fun onInvalidData(dataType: InvalidDataType)
    }
}