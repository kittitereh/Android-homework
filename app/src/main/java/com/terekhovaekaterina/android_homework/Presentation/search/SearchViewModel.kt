package com.terekhovaekaterina.android_homework

import android.media.Rating
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.terekhovaekaterina.android_homework.Presentation.common.SingleLiveEvent


class SearchViewModel: ViewModel() {

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _errorMessage = SingleLiveEvent<SearchErrorType>()
    val errorMessage: LiveData<SearchErrorType> = _errorMessage

    override fun onCleared() {
        super.onCleared()
    }

    fun onSubmit(
        searchType: SearchType,
        ratingFrom: Int,
        ratingTo: Int,
        yearFrom:String,
        yearTo:String,
    ) {

        val yearFromInt = yearFrom.toIntOrNull()
        val yearToInt = yearTo.toIntOrNull()

        if(yearFromInt != null && yearToInt != null && yearFromInt > yearToInt) {
            _errorMessage.value = SearchErrorType.YEAR_FROM_MORE_THAN_YEAR_TO
            return
        }

        _loading.value = true
    }
}

enum class SearchType{
    ALL, FILMS, SHOW, SERIES
}

enum class SearchErrorType {
    YEAR_FROM_MORE_THAN_YEAR_TO
}