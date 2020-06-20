package com.assignment.assignment.model.response


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class LinkFlairRichtextItem(

	@field:SerializedName("t")
	val T: String? = null,

	@field:SerializedName("e")
	val E: String? = null
): Serializable