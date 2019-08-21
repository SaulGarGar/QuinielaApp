package com.example.quinielaapp.modules.sellerAdminModules.usersDetails.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quinielaapp.R
import com.example.quinielaapp.modules.sellerAdminModules.usersDetails.presenter.UsersDetailPresenter

class UsersDetailActivity : AppCompatActivity(), UsersDetailPresenter.OnUsersDetailEvent {

    private lateinit var presenter: UsersDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_detail)

        initData()
        initViews()
        onClickEvents()
    }

    fun initData(){
        presenter = UsersDetailPresenter(this, this)
    }

    fun initViews(){

    }

    fun onClickEvents(){

    }
}
