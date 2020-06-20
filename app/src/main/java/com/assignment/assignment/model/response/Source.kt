package com.assignment.assignment.model.response


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Source(

    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("url")
    val url: String? = "",

    @field:SerializedName("height")
    val height: Int? = null
) : Serializable {

    fun getDownloadUrl(): String {
        when (url?.contains("?")) {
            true -> return url.split("?")[0]
        }
		return url!!
    }
}