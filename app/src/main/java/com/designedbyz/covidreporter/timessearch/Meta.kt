package com.designedbyz.covidreporter.timessearch

import com.fasterxml.jackson.annotation.JsonCreator

class Meta @JsonCreator constructor(val hits: Int, val offset: Int, val time: Int) {
}
