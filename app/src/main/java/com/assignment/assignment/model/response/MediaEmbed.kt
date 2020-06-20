package com.assignment.assignment.model.response


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MediaEmbed(

	@field:SerializedName("scrolling")
	val scrolling: Boolean? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
): Serializable