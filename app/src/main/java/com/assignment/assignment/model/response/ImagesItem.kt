package com.assignment.assignment.model.response


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ImagesItem(

	@field:SerializedName("resolutions")
	val resolutions: List<ResolutionsItem?>? = null,

	@field:SerializedName("source")
	val source: Source,

	@field:SerializedName("variants")
	val variants: Variants? = null,

	@field:SerializedName("id")
	val id: String? = null
):Serializable