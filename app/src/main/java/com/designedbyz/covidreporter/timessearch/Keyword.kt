package com.designedbyz.covidreporter.timessearch

import com.fasterxml.jackson.annotation.JsonCreator

data class Keyword @JsonCreator constructor(val name: String?, val value: String?, val rank: Int?, val major: String?) {
}

