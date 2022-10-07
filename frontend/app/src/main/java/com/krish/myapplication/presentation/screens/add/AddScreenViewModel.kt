package com.krish.myapplication.presentation.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krish.myapplication.data.model.Note
import com.krish.myapplication.domain.LocalDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(
    private val localDataSource: LocalDataSource
): ViewModel() {
    fun insertNote(note : Note){
        viewModelScope.launch(Dispatchers.IO) {
            localDataSource.insertNote(note)
        }
    }
}