package com.designedbyz.covidreporter.timessearch

import com.fasterxml.jackson.annotation.JsonCreator

data class Person @JsonCreator constructor(val firstname: String?, val middlename: String?, val lastname: String?,
                                           val qualifier: String?, val title: String?, val role: String?,
                                           val organization: String?, val rank: String?) {
}
