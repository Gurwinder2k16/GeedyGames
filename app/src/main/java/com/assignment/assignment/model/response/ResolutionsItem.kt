package com.assignment.assignment.model.response


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ResolutionsItem(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
):Serializable