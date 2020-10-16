package com.designedbyz.covidreporter.ui

import android.widget.ImageView
import com.squareup.picasso.Picasso
import javax.inject.Inject

class ImageLoader @Inject constructor(private val picasso: Picasso) {

    fun load(imageView: ImageView, url: String) {
        picasso.load(url)
            .into(imageView)
    }
}
