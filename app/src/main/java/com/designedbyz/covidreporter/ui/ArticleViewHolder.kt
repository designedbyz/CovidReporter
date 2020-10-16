package com.designedbyz.covidreporter.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.designedbyz.covidreporter.timessearch.Article

abstract class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bindView(article: Article)
}
