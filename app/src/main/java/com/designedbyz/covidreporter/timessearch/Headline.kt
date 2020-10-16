package com.designedbyz.covidreporter.timessearch

import com.fasterxml.jackson.annotation.JsonCreator

data class Headline @JsonCreator constructor(val main: String?, val kicker: String?, val content_kicker: String?,
                                             val print_headline: String?, val name: String?, val seo: String?, val sub: String? ) {
}
