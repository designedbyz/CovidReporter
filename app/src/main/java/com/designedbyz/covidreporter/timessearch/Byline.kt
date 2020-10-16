package com.designedbyz.covidreporter.timessearch

import com.fasterxml.jackson.annotation.JsonCreator

data
class Byline @JsonCreator constructor(val original: String?, val person: Array<Person>?, val organization: String?) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Byline

        if (original != other.original) return false
        if (person != null) {
            if (other.person == null) return false
            if (!person.contentEquals(other.person)) return false
        } else if (other.person != null) return false
        if (organization != other.organization) return false

        return true
    }

    override fun hashCode(): Int {
        var result = original?.hashCode() ?: 0
        result = 31 * result + (person?.contentHashCode() ?: 0)
        result = 31 * result + (organization?.hashCode() ?: 0)
        return result
    }

}
