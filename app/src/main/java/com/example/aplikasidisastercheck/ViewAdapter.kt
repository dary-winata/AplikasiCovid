package com.example.aplikasidisastercheck

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlin.math.log


class ViewAdapter(var data: List<ArticlesItem>?): RecyclerView.Adapter<ViewAdapter.holderNewsAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderNewsAdapter {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.news_card, parent, false)
        return holderNewsAdapter(inflater)
    }

    override fun onBindViewHolder(holder: holderNewsAdapter, position: Int) {
        Log.d("false", "false")
        if(checkString(data?.get(position)))
            holder.bind(data?.get(position))
    }

    override fun getItemCount(): Int {
            return data?.size ?: 0
    }

    class holderNewsAdapter(inflate: View): RecyclerView.ViewHolder(inflate) {
        private val title: TextView = itemView.findViewById(R.id.tvTitle)
        private val descr: TextView = itemView.findViewById(R.id.tvDesc)
        private val img: ImageView = itemView.findViewById(R.id.imgNews)

        fun bind(get: ArticlesItem?) {
            title.text = get?.title
            descr.text = get?.description
            Picasso.get().load(get?.urlToImage).fit().centerCrop().into(img)
        }
    }

    fun checkString(data: ArticlesItem?): Boolean {
        data as ArticlesItem
        if(data.content!!.contains("COVID", ignoreCase = true) ||
                data.title!!.contains("COVID", ignoreCase = true) ||
                data.description!!.contains("COVID", ignoreCase = true))
            return true ?: false
        return false
    }
}