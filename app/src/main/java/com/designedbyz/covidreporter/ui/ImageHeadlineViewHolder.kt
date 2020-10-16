package com.designedbyz.covidreporter.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.designedbyz.covidreporter.R
import com.designedbyz.covidreporter.timessearch.Article

class ImageHeadlineViewHolder(itemView: View, private val imageLoader: ImageLoader) : ArticleViewHolder(itemView) {

    companion object {
        const val IMAGE_URL_BASE = "https://static01.nyt.com/"
    }

    override fun bindView(article: Article) {
        itemView.findViewById<TextView>(R.id.image_article_headline_title).text = article.headline?.main
        val imageView = itemView.findViewById<ImageView>(R.id.image_article_headline_image)
        imageLoader.load(imageView,
            IMAGE_URL_BASE + article.multimedia.first { it.type == "image" }.url)
        imageView.contentDescription = article.multimedia[0].caption ?: "article title image"
    }
}
