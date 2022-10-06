package com.krish.myapplication.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.krish.myapplication.domain.LocalDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val localDataSource: LocalDataSource
) : ViewModel() {
    val getAllNotes = localDataSource.getAllNotes()
}