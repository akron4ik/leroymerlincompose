package com.aronovak.leroymerlintest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainScreenViewModel: ViewModel() {
    private val _searchText:MutableLiveData<String> = MutableLiveData("")
    val searchText = _searchText

    fun setSearchText(text: String){
        _searchText.postValue(text)
    }
}