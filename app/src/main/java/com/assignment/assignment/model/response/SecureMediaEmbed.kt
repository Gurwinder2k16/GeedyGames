package com.assignment.assignment.model.response


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class SecureMediaEmbed(

	@field:SerializedName("scrolling")
	val scrolling: Boolean? = null,

	@field:SerializedName("media_domain_url")
	val mediaDomainUrl: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
): Serializable