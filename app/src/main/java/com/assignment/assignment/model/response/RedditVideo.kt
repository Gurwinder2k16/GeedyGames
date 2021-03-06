package com.assignment.assignment.model.response


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class RedditVideo(

	@field:SerializedName("duration")
	val duration: Int? = null,

	@field:SerializedName("is_gif")
	val isGif: Boolean? = null,

	@field:SerializedName("dash_url")
	val dashUrl: String? = null,

	@field:SerializedName("fallback_url")
	val fallbackUrl: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("scrubber_media_url")
	val scrubberMediaUrl: String? = null,

	@field:SerializedName("hls_url")
	val hlsUrl: String? = null,

	@field:SerializedName("transcoding_status")
	val transcodingStatus: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
): Serializable