package com.example.quotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val newsList: ArrayList<NewsItem>):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsAdapter.ViewHolder(v)

    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.bindItems(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(news: NewsItem) {

            val title = itemView.findViewById(R.id.title) as TextView
            val summary = itemView.findViewById(R.id.summary) as TextView
            val country = itemView.findViewById(R.id.country) as TextView
            val author = itemView.findViewById(R.id.author) as TextView

            title.text = news.title
            summary.text = news.summary
            country.text = news.country
            author.text = news.author

        }
    }

}