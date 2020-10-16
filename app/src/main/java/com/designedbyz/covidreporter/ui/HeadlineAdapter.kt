package com.designedbyz.covidreporter.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.designedbyz.covidreporter.R
import com.designedbyz.covidreporter.timessearch.Article
import javax.inject.Inject

class HeadlineAdapter @Inject constructor(private val imageLoader: ImageLoader):
    RecyclerView.Adapter<ArticleViewHolder>() {

    enum class ViewType{
        IMAGE,
        BASIC
    }

    private var articles: ArrayList<Article> = ArrayList()

    fun addArticles(newArticles: Array<Article>) {
        articles.addAll(newArticles)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return if(viewType == ViewType.IMAGE.ordinal) {
            ImageHeadlineViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.image_headline_view, parent, false), imageLoader)
        } else {
            BasicHeadlineViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.basic_headline_view, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindView(articles[position])
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (articles[position].multimedia.any { it.type == "image" }) {
            ViewType.IMAGE.ordinal
        } else {
            ViewType.BASIC.ordinal
        }
    }
}
