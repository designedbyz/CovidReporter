package com.designedbyz.covidreporter.timessearch

import com.fasterxml.jackson.annotation.JsonCreator

data class Body @JsonCreator constructor(val status: String, val copyright: String, val response: Response) {
}
