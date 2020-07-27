package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        bottomNavView.setupWithNavController(findNavController(R.id.newsNavFragment))
        setupActionBarWithNavController(findNavController(R.id.newsNavFragment))

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.newsNavFragment)

        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
