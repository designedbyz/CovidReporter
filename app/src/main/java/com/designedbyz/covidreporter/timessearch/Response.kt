package com.designedbyz.covidreporter.timessearch

import com.fasterxml.jackson.annotation.JsonCreator

data class Response @JsonCreator constructor(val docs: Array<Article>?, val meta: Meta) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Response

        if (docs != null) {
            if (other.docs == null) return false
            if (!docs.contentEquals(other.docs)) return false
        } else if (other.docs != null) return false
        if (meta != other.meta) return false

        return true
    }

    override fun hashCode(): Int {
        var result = docs?.contentHashCode() ?: 0
        result = 31 * result + meta.hashCode()
        return result
    }
}
