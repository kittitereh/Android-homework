package com.terekhovaekaterina.android_homework.Presentation.search

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import androidx.core.view.isVisible
import com.terekhovaekaterina.android_homework.*
import com.terekhovaekaterina.android_homework.Presentation.common.BaseActivity

import com.terekhovaekaterina.android_homework.databinding.ActivitySearchBinding

class SearchActivity: BaseActivity() {

    private val viewModel by viewModels<SearchViewModel>()
    private val viewBinding by viewBinding(ActivitySearchBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        viewBinding.searchSubmit.setOnClickListener{
            viewModel.onSubmit(
                searchType = when (viewBinding.searchTypeGroup.checkedRadioButtonId) {
                    R.id.search_type_group_all -> SearchType.ALL
                    R.id.search_type_group_film -> SearchType.FILMS
                    R.id.search_type_group_series -> SearchType.SERIES
                    else -> SearchType.SHOW
                },
                ratingFrom = (viewBinding.searchRatingSpinnerFrom.selectedItem as String).toInt(),
                ratingTo = (viewBinding.searchRatingSpinnerTo.selectedItem as String).toInt(),
                yearFrom = viewBinding.searchYearSpinnerFrom.text.toString(),
                yearTo = viewBinding.searchYearSpinnerTo.text.toString(),
            )
        }

        viewBinding.searchRatingSpinnerFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val ratingFromPosition = viewBinding.searchRatingSpinnerFrom.selectedItemPosition
                val ratingToPosition = viewBinding.searchRatingSpinnerTo.selectedItemPosition
                if(ratingFromPosition > ratingToPosition){
                    viewBinding.searchRatingSpinnerTo.setSelection(ratingFromPosition)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        viewBinding.searchRatingSpinnerTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val ratingFromPosition = viewBinding.searchRatingSpinnerFrom.selectedItemPosition
                val ratingToPosition = viewBinding.searchRatingSpinnerTo.selectedItemPosition
                if(ratingFromPosition > ratingToPosition){
                    viewBinding.searchRatingSpinnerFrom.setSelection(ratingToPosition)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        viewModel.loading.observe(this) {
            viewBinding.searchProgress.isVisible = it
            viewBinding.searchClickStub.isVisible = it

        }

        viewModel.errorMessage.observe(this){
            showError(it.toText())
        }
    }

    private fun showError(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun SearchErrorType.toText(): String {
        return when (this) {
            SearchErrorType.YEAR_FROM_MORE_THAN_YEAR_TO -> getString(R.string.search_year_from_more_than_to)
        }

    }

}