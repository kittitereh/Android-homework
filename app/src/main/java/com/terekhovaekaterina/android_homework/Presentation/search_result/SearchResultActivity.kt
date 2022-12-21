package com.terekhovaekaterina.android_homework.Presentation.search_result

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.terekhovaekaterina.android_homework.Presentation.common.BaseActivity
import com.terekhovaekaterina.android_homework.Presentation.details.FilmDetailActivity
import com.terekhovaekaterina.android_homework.Presentation.di.NetworkProvider
import com.terekhovaekaterina.android_homework.Presentation.search.SearchActivity
import com.terekhovaekaterina.android_homework.Presentation.entity.Film
import com.terekhovaekaterina.android_homework.R
import com.terekhovaekaterina.android_homework.databinding.ActivitySearchResultBinding


class SearchResultActivity: BaseActivity() {

    private val viewModel by viewModels<SearchResultViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SearchResultViewModel(
                    NetworkProvider.getFilmsRepository()
                ) as T
            }
        }
    }
    private val viewBinding by viewBinding(ActivitySearchResultBinding::bind)
    private val searchResultAdapter = SearchResultAdapter{viewModel.onFilmClicked(it)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        viewBinding.mainSearch.setOnClickListener {
            openSearch()
        }
        with(viewBinding.searchResultList){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = searchResultAdapter
        }

        viewModel.films.observe(this){ films ->
            searchResultAdapter.setData(films)
        }

        viewModel.openDetail.observe(this){
            openDetail(it)
        }

    }



    private fun openDetail(film:Film) {
        startActivity(
            Intent(this, FilmDetailActivity::class.java)
                .apply {
                    putExtra(FilmDetailActivity.FILM_DETAIL_ARGUMENT_KEY, film)
                },
        )
    }

    private fun openSearch() {
        startActivity(Intent(this, SearchActivity::class.java))
    }

}




