package com.terekhovaekaterina.android_homework.Presentation.search_result

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.terekhovaekaterina.android_homework.Presentation.search.SearchActivity
import com.terekhovaekaterina.android_homework.R
import com.terekhovaekaterina.android_homework.databinding.ActivitySearchBinding
import com.terekhovaekaterina.android_homework.databinding.TopMemeLayoutBinding


class TopMemeAdapter: RecyclerView.Adapter<TopMemeAdapter.Holder>() {

    private var meme: List<Film> = emptyList()

    private fun setData(meme: List<Film>){
        this.meme = meme
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = meme.size

    class Holder(val binding: TopMemeLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = TopMemeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = meme[position]
        with(holder.binding){
            topMemeName.text = item.name
            topMemeYear.text = item.year.toString()
        }
    }




}

