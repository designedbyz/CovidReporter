package com.designedbyz.covidreporter.ui

import android.view.View
import android.widget.TextView
import com.designedbyz.covidreporter.timessearch.Article

class BasicHeadlineViewHolder(itemView: View) : ArticleViewHolder(itemView) {
    override fun bindView(article: Article) {
        (itemView as TextView).text = article.headline?.main
    }
}
