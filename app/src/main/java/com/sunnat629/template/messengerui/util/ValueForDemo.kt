package com.sunnat629.template.messengerui.util

import android.support.v4.app.FragmentActivity
import com.sunnat629.template.messengerui.R
import com.sunnat629.template.messengerui.model.DescFeaturedModel
import com.sunnat629.template.messengerui.model.DescPopularModel
import com.sunnat629.template.messengerui.model.DescRecentModel
import java.sql.Time
import java.util.ArrayList
import kotlin.random.Random

object ValueForDemo {
    private lateinit var random: Random

    fun getRandomBoolean(): Boolean{
        return Math.random() > 0.5
    }

    fun getRandomTime(): Time{
        val millisInDay = 24 * 60 * 60 * 1000
        return Time(random.nextInt(millisInDay).toLong())
    }

    fun profileFeaturedList(activity: FragmentActivity?): List<DescFeaturedModel> {
        val descFeaturedModelList: ArrayList<DescFeaturedModel> = ArrayList()

        for (count in 1..3) {
            descFeaturedModelList.add(
                DescFeaturedModel(
                    activity!!.getString(R.string.full_name),
                    activity.getString(R.string.replies_time),
                    activity.getString(R.string.description),
                    R.drawable.sunnat
                )
            )
        }
        return descFeaturedModelList
    }

    fun profileRecentList(activity: FragmentActivity?): List<DescRecentModel> {
        val descRecentModel: ArrayList<DescRecentModel> = ArrayList()

        for (count in 1..100) {

            descRecentModel.add(
                DescRecentModel(
                    activity!!.getString(R.string.full_name),
                    R.drawable.sunnat
                )
            )
        }

        return descRecentModel
    }

    fun profilePopularList(activity: FragmentActivity?): List<DescPopularModel> {
        val descPopularModel: ArrayList<DescPopularModel> = ArrayList()

        for (count in 1..100) {
            val boolean = getRandomBoolean()
            descPopularModel.add(
                DescPopularModel(
                    activity!!.getString(R.string.full_name),
                    getIsAutomatedString(activity,boolean),
                    activity.getString(R.string.description),
                    R.drawable.sunnat,
                    boolean
                )
            )
        }

        return descPopularModel
    }

    private fun getIsAutomatedString(activity: FragmentActivity, boolean: Boolean): String {
        return if(boolean){
            activity.getString(R.string.replies_time)
        }else {
            activity.getString(R.string.automated)
        }
    }


}