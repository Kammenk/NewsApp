package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.example.newsapp.database.ArticleDatabase
import com.example.newsapp.repository.NewsRepo
import com.example.newsapp.ui.viewmodel.NewsViewModel
import com.example.newsapp.ui.viewmodel.NewsViewModelProviderFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity: AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)


        val newsRepo = NewsRepo(ArticleDatabase(this))
        val newsViewModelProviderFactory = NewsViewModelProviderFactory(newsRepo)
        viewModel = ViewModelProvider(this,newsViewModelProviderFactory).get(NewsViewModel::class.java)

        bottomNavView.setupWithNavController(findNavController(R.id.newsNavFragment))
        setupActionBarWithNavController(findNavController(R.id.newsNavFragment))

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.newsNavFragment)

        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
