package com.terekhovaekaterina.android_homework.Presentation.search_result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terekhovaekaterina.android_homework.Presentation.common.SingleLiveEvent
import com.terekhovaekaterina.android_homework.Presentation.domain.FilmRepository
import com.terekhovaekaterina.android_homework.Presentation.domain.FilmsGenres
import com.terekhovaekaterina.android_homework.Presentation.entity.Film
import kotlinx.coroutines.launch

class SearchResultViewModel(
    private val filmRepository: FilmRepository,
) : ViewModel(){

    private val _films = MutableLiveData<List<Film>>()


    val films: LiveData<List<Film>> = _films

    private val _openDetail = SingleLiveEvent<Film>()
    val openDetail: LiveData<Film> = _openDetail

    init {
        viewModelScope.launch{
            val films = filmRepository.getFilms(FilmsGenres.ACTION)
            _films.value = films
        }
    }

    fun onFilmClicked(film: Film){
        _openDetail.value = film

    }
}