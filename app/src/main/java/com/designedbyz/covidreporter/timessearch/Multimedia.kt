package com.designedbyz.covidreporter.timessearch

import com.fasterxml.jackson.annotation.JsonCreator

data class Multimedia @JsonCreator constructor(val rank: Int?, val subtype: String?, val caption: String?, val credit: String?,
                                               val type: String?, val url: String, val height: Int?, val width: Int?,
                                               val crop_name: String?) {
}
