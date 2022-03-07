package com.example.aplikasidisastercheck

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewAdapter(): RecyclerView.Adapter<ViewHolder>() {
    var data: List<InfoFaskes>? = emptyList()

    fun setDataList(paramData: List<InfoFaskes>?){
        data = paramData
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        inflater.inflate(R.layout.news_card, parent, false)
        return ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}