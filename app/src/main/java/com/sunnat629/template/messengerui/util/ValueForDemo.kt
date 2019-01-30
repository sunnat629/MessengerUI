package com.sunnat629.template.messengerui.util

import java.sql.Time
import kotlin.random.Random

object ValueForDemo {
    private lateinit var random: Random

    fun getRandomBoolean(): Boolean{
        return Math.random() > 0.5
    }

    fun getRandomTime(): Time{
        val millisInDay = 24 * 60 * 60 * 1000
        return Time(random.nextInt(millisInDay) as Long)
    }


}