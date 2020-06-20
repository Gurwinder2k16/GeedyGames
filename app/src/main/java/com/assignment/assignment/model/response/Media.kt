package com.assignment.assignment.model.response


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Media(

    @field:SerializedName("oembed")
    val oembed: Oembed? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("reddit_video")
    val redditVideo: RedditVideo? = null
): Serializable