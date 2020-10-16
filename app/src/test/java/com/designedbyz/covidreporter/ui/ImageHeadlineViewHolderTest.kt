package com.designedbyz.covidreporter.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.designedbyz.covidreporter.R
import com.designedbyz.covidreporter.timessearch.Article
import com.designedbyz.covidreporter.timessearch.Multimedia
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class ImageHeadlineViewHolderTest {

    @RelaxedMockK lateinit var imageLoader: ImageLoader
    @RelaxedMockK lateinit var itemView: View
    @RelaxedMockK lateinit var imageView: ImageView
    @RelaxedMockK lateinit var textView: TextView
    @RelaxedMockK lateinit var article: Article
    @RelaxedMockK lateinit var multimedia1: Multimedia
    @RelaxedMockK lateinit var multimedia2: Multimedia
    @RelaxedMockK lateinit var multimedia3: Multimedia

    lateinit var viewHolder: ImageHeadlineViewHolder

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewHolder = ImageHeadlineViewHolder(itemView, imageLoader)
    }

    @Test
    fun testBindViewLoadsFirstImage() {
        every { multimedia1.type } returns "audio"
        every { multimedia2.type } returns "image"
        every { multimedia3.type } returns "image"
        every { article.multimedia } returns arrayOf(multimedia1, multimedia2, multimedia3)
        every { itemView.findViewById<ImageView>(R.id.image_article_headline_image)} returns imageView
        every { itemView.findViewById<TextView>(R.id.image_article_headline_title)} returns textView

        viewHolder.bindView(article)
        verify(exactly = 1) {multimedia2.url}
        verify(exactly = 0) {multimedia3.url}
    }
}
