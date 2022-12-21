package com.terekhovaekaterina.android_homework.Presentation.search_result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.terekhovaekaterina.android_homework.Presentation.common.SingleLiveEvent

class SearchResultViewModel(name: String) : ViewModel(){

    private val _result = MutableLiveData(listOf(
        Film("Zhozho1", 2020),
        Film("Zhozho2", 2020),
        Film("Zhozho3", 2020),
        Film("Zhozho4", 2020),
        Film("Zhozho5", 2020),
    )
    )

    val results: LiveData<List<Film>> = _result

    private val _openDetail = SingleLiveEvent<Film>()
    val openDetail: LiveData<Film> = _openDetail

    fun onResultClicked(result:Film){
        _openDetail.value = result

    }
}