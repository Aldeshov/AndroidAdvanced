package com.ankit.trendinggit.view.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ankit.trendinggit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.main_nav_fragment))
    }

    fun onClickTrending(view: View) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_fragment) as NavHostFragment
        navHostFragment.navController.setGraph(R.navigation.nav_graph)
        //navHostFragment.navController.navigateUp()

        val bundle = Bundle()
        bundle.putInt("type", 0)
        navHostFragment.navController.navigate(R.id.repoListFragment, bundle)
    }

    fun onClickGo(view: View) {
        val username = username.text.toString()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_fragment) as NavHostFragment
        navHostFragment.navController.setGraph(R.navigation.nav_graph)
        //navHostFragment.navController.navigateUp()

        val bundle = Bundle()
        bundle.putInt("type", 1)
        bundle.putString("username", username)
        navHostFragment.navController.navigate(R.id.repoListFragment, bundle)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_fragment).navigateUp()
}