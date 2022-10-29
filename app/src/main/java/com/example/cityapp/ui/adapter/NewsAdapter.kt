package com.example.cityapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cityapp.R
import com.example.cityapp.data.entity.NewsInfo
import com.example.cityapp.databinding.CardDesignNewsBinding

class NewsAdapter(
    private var newsList: List<NewsInfo>,
    private var onItemClick: (NewsInfo) -> Unit
) :
    RecyclerView.Adapter<NewsAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(val binding: CardDesignNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(news: NewsInfo) {

            with(binding) {

                newsObject = news //newsObject, card_design_news.xml'deki değişken

                cardViewNews.setOnClickListener {  //habere tıklandığında bottom sheet olarak detaylar açılır
                    onItemClick(news)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CardDesignNewsBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.card_design_news, parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) =
        holder.bind(newsList[position])

    override fun getItemCount() = newsList.size
}