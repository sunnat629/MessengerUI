package com.sunnat629.template.messengerui.model

data class DescPopularModel (
    val profileName: String,
    val profileReplay: String,
    val profileDescription: String,
    val profileImage: Int,
    val isAutomated: Boolean
)

data class DescFeaturedModel(
    val profileName: String,
    val profileReplay: String,
    val profileDescription: String,
    val profileImage: Int
)

data class DescRecentModel(
    val profileName: String,
    val profileImage: Int
)