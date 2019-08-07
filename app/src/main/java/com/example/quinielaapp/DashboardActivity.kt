package com.example.quinielaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.example.quinielaapp.modules.actualJourney.views.ActualJourneyFragment
import com.example.quinielaapp.modules.profile.views.ProfileFragment
import com.example.quinielaapp.modules.results.views.ResultsFragment
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setBottomNavigation()
    }

    private fun setBottomNavigation(){
        bottom_navigation_view.itemIconTintList = null
        bottom_navigation_view.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profile -> {
                    val fragment = ProfileFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.actual_journey -> {
                    val fragment = ActualJourneyFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.results -> {
                    val fragment = ResultsFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
        bottom_navigation_view.selectedItemId = R.id.actual_journey
        val fragment = ActualJourneyFragment.newInstance()
        openFragment(fragment)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }
}
