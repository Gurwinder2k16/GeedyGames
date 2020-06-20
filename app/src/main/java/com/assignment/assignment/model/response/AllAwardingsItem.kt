package com.assignment.assignment.model.response


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class AllAwardingsItem(

	@field:SerializedName("icon_width")
	val iconWidth: Int? = null,

	@field:SerializedName("end_date")
	val endDate: Any? = null,

	@field:SerializedName("award_sub_type")
	val awardSubType: String? = null,

	@field:SerializedName("days_of_drip_extension")
	val daysOfDripExtension: Int? = null,

	@field:SerializedName("coin_reward")
	val coinReward: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("resized_icons")
	val resizedIcons: List<ResizedIconsItem?>? = null,

	@field:SerializedName("coin_price")
	val coinPrice: Int? = null,

	@field:SerializedName("subreddit_coin_reward")
	val subredditCoinReward: Int? = null,

	@field:SerializedName("icon_format")
	val iconFormat: Any? = null,

	@field:SerializedName("award_type")
	val awardType: String? = null,

	@field:SerializedName("static_icon_url")
	val staticIconUrl: String? = null,

	@field:SerializedName("subreddit_id")
	val subredditId: Any? = null,

	@field:SerializedName("is_enabled")
	val isEnabled: Boolean? = null,

	@field:SerializedName("penny_price")
	val pennyPrice: Any? = null,

	@field:SerializedName("penny_donate")
	val pennyDonate: Any? = null,

	@field:SerializedName("static_icon_height")
	val staticIconHeight: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("days_of_premium")
	val daysOfPremium: Int? = null,

	@field:SerializedName("start_date")
	val startDate: Any? = null,

	@field:SerializedName("icon_url")
	val iconUrl: String? = null,

	@field:SerializedName("is_new")
	val isNew: Boolean? = null,

	@field:SerializedName("icon_height")
	val iconHeight: Int? = null,

	@field:SerializedName("static_icon_width")
	val staticIconWidth: Int? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("resized_static_icons")
	val resizedStaticIcons: List<ResizedStaticIconsItem?>? = null,

	@field:SerializedName("giver_coin_reward")
	val giverCoinReward: Any? = null,

	@field:SerializedName("name")
	val name: String? = null
): Serializable