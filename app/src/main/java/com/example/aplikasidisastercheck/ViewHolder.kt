package com.example.aplikasidisastercheck

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.news_card, parent, false)) {
    private lateinit var title: TextView
    private lateinit var text: TextView

    init {
        title = itemView.findViewById(R.id.tvTitle)
    }

    fun bind(news: ArticlesItem?) {
        title.text = news?.title
    }
}