package com.terekhovaekaterina.android_homework.Presentation.search_result

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.terekhovaekaterina.android_homework.Presentation.entity.Film
import com.terekhovaekaterina.android_homework.databinding.FilmsItemBinding



class SearchResultAdapter(
    private val onFilmClicked: (Film) -> Unit,
): ListAdapter<Film, SearchResultAdapter.Holder>(
    object: DiffUtil.ItemCallback<Film>() {
        override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem == newItem
        }

    }

){

    fun setData(films: List<Film>){
        submitList(films)
    }


    class Holder(val binding: FilmsItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = FilmsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        with(holder.binding){
            filmItemName.text = item.name
            filmItemYear.text = item.year.toString()
            root.setOnClickListener{ onFilmClicked(item)}
        }
    }
}

