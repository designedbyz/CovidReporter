package com.designedbyz.covidreporter.ui

import com.designedbyz.covidreporter.timessearch.Article
import com.designedbyz.covidreporter.timessearch.Multimedia
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HeadlineAdapterTest {

    @RelaxedMockK lateinit var article1: Article
    @RelaxedMockK lateinit var multimedia1: Multimedia
    @RelaxedMockK lateinit var multimedia2: Multimedia
    @RelaxedMockK lateinit var multimedia3: Multimedia
    @RelaxedMockK lateinit var imageLoader: ImageLoader
    lateinit var headlineAdapter: HeadlineAdapter

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        headlineAdapter = HeadlineAdapter(imageLoader)
    }

    @Test
    fun testBasicReturnedWhenNoMultimedia() {
        every { article1.multimedia } returns emptyArray()
        headlineAdapter.addArticles(arrayOf(article1))
        assertEquals(HeadlineAdapter.ViewType.BASIC.ordinal, headlineAdapter.getItemViewType(0))
    }

    @Test
    fun testBasicReturnedWhenMultimediaIsNotImage() {
        every { multimedia1.type } returns "audio"
        every { multimedia2.type } returns "video"
        every { article1.multimedia } returns arrayOf(multimedia1, multimedia2, multimedia3)
        headlineAdapter.addArticles(arrayOf(article1))
        assertEquals(HeadlineAdapter.ViewType.BASIC.ordinal, headlineAdapter.getItemViewType(0))
    }

    @Test
    fun testImageReturnedWhenMultiMediaIsImage() {
        every { multimedia1.type } returns "audio"
        every { multimedia2.type } returns "image"
        every { article1.multimedia } returns arrayOf(multimedia1, multimedia2, multimedia3)
        headlineAdapter.addArticles(arrayOf(article1))
        assertEquals(HeadlineAdapter.ViewType.IMAGE.ordinal, headlineAdapter.getItemViewType(0))
    }
}
