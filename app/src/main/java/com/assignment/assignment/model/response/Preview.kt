package com.assignment.assignment.model.response


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Preview(

	@field:SerializedName("images")
	val images: ArrayList<ImagesItem> =ArrayList<ImagesItem>(),

	@field:SerializedName("enabled")
	val enabled: Boolean? = null
): Serializable