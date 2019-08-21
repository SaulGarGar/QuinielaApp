package com.example.quinielaapp.modules.sellerAdminModules.searchUsers.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quinielaapp.R
import com.example.quinielaapp.modules.sellerAdminModules.searchUsers.presenter.SearchUsersPresenter
import com.example.quinielaapp.modules.sellerAdminModules.usersDetails.views.UsersDetailActivity
import com.google.android.material.button.MaterialButton

class SearchUsersActivity : AppCompatActivity(), SearchUsersPresenter.OnSearchUsersEvent {

    private lateinit var presenter: SearchUsersPresenter

    private lateinit var searchButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_users)

        initData()
        initViews()
        onClickEvents()
    }

    fun initData(){
        presenter = SearchUsersPresenter(this, this)
    }

    fun initViews(){
        searchButton = findViewById(R.id.search_button)
    }

    fun onClickEvents(){
        searchButton.setOnClickListener {
            val intent = Intent(baseContext, UsersDetailActivity::class.java)
                startActivity(intent)
        }
    }
}
