package com.sunnat629.template.messengerui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.sunnat629.template.messengerui.R
import com.sunnat629.template.messengerui.model.DescPopularModel


class DiscoverPopularAdapter(
    private var context: Context?,
    private var descPopularModelList: List<DescPopularModel>
) :RecyclerView.Adapter<DiscoverPopularAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.disc_popular, viewGroup, false)

        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return descPopularModelList.size
    }

    fun setItems(descPopularModelList: List<DescPopularModel>) {
        this.descPopularModelList = emptyList()
        this.descPopularModelList = descPopularModelList
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val descPopularModel = descPopularModelList[position]

        viewHolder.fullName.text = descPopularModel.profileName
        viewHolder.repliesTime.text = descPopularModel.profileReplay

        viewHolder.flash.visibility = if (descPopularModel.isAutomated){
            View.GONE
        } else{
            View.VISIBLE
        }

        Picasso.get().load(descPopularModel.profileImage).into(viewHolder.proPic)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fullName = view.findViewById(R.id.disc_popular_fullName) as TextView
        val description = view.findViewById(R.id.disc_popular_description) as TextView
        val repliesTime = view.findViewById(R.id.disc_popular_repliesTime) as TextView

        val proPic = view.findViewById(R.id.disc_popular_image) as ImageView
        val flash = view.findViewById(R.id.disc_popular_flash) as ImageView
//        val mute = view.findViewById(R.id.mute) as ImageView

    }
}