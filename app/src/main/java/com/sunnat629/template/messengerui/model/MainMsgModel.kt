package com.sunnat629.template.messengerui.model

import java.util.*

data class MainMsgModel(
    val profileName: String,
    val profileImage: Int,
    val lastMsg: String,
    val time: Date,
    val isOnline: Boolean,
    val isMute: Boolean,
    val isSeen: Boolean/*,
    val offlineTime: String*/
)