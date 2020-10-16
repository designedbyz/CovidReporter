package com.designedbyz.covidreporter.timessearch

import com.fasterxml.jackson.annotation.JsonCreator

data class Article @JsonCreator constructor(val web_url: String?, val snippet: String?, val print_page: String?,
                   val source: String?, val multimedia: Array<Multimedia>, val headline: Headline?,
                   val keywords: Array<Keyword>?, val pub_date: String?, val document_type: String?,
                   val news_desk: String?, val byline: Byline, val type_of_material: String?,
                   val _id: String?, val word_count: Int?, val score: Int?, val uri: String?) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Article

        if (web_url != other.web_url) return false
        if (snippet != other.snippet) return false
        if (print_page != other.print_page) return false
        if (source != other.source) return false
        if (!multimedia.contentEquals(other.multimedia)) return false
        if (headline != other.headline) return false
        if (keywords != null) {
            if (other.keywords == null) return false
            if (!keywords.contentEquals(other.keywords)) return false
        } else if (other.keywords != null) return false
        if (pub_date != other.pub_date) return false
        if (document_type != other.document_type) return false
        if (news_desk != other.news_desk) return false
        if (byline != other.byline) return false
        if (type_of_material != other.type_of_material) return false
        if (_id != other._id) return false
        if (word_count != other.word_count) return false
        if (score != other.score) return false
        if (uri != other.uri) return false

        return true
    }

    override fun hashCode(): Int {
        var result = web_url?.hashCode() ?: 0
        result = 31 * result + (snippet?.hashCode() ?: 0)
        result = 31 * result + (print_page?.hashCode() ?: 0)
        result = 31 * result + (source?.hashCode() ?: 0)
        result = 31 * result + multimedia.contentHashCode()
        result = 31 * result + (headline?.hashCode() ?: 0)
        result = 31 * result + (keywords?.contentHashCode() ?: 0)
        result = 31 * result + (pub_date?.hashCode() ?: 0)
        result = 31 * result + (document_type?.hashCode() ?: 0)
        result = 31 * result + (news_desk?.hashCode() ?: 0)
        result = 31 * result + byline.hashCode()
        result = 31 * result + (type_of_material?.hashCode() ?: 0)
        result = 31 * result + (_id?.hashCode() ?: 0)
        result = 31 * result + (word_count ?: 0)
        result = 31 * result + (score ?: 0)
        result = 31 * result + (uri?.hashCode() ?: 0)
        return result
    }


}




