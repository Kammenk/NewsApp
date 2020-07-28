package com.example.newsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newsapp.repository.NewsRepo

class NewsViewModel(val newsRepo: NewsRepo): ViewModel() {
}