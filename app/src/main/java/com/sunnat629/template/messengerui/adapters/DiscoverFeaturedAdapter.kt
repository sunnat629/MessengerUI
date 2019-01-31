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
import com.sunnat629.template.messengerui.model.DescFeaturedModel
import com.sunnat629.template.messengerui.model.DescPopularModel


class DiscoverFeaturedAdapter(private var context: Context?,
                              private var descFeaturedModelList: List<DescFeaturedModel>
):
RecyclerView.Adapter<DiscoverFeaturedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.disc_featured, viewGroup, false)

        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return descFeaturedModelList.size
    }

    fun setItems(descFeaturedModelList: List<DescFeaturedModel>) {
        this.descFeaturedModelList = emptyList()
        this.descFeaturedModelList = descFeaturedModelList
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val descFeaturedModel = descFeaturedModelList[position]

        viewHolder.fullName.text = descFeaturedModel.profileName
        viewHolder.repliesTime.text = descFeaturedModel.profileReplay
        viewHolder.description.text = descFeaturedModel.profileDescription

        Picasso.get().load(descFeaturedModel.profileImage).into(viewHolder.proPic)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fullName = view.findViewById(R.id.disc_featured_fullName) as TextView
        val description = view.findViewById(R.id.disc_featured_description) as TextView
        val repliesTime = view.findViewById(R.id.disc_featured_repliesTime) as TextView

        val proPic = view.findViewById(R.id.disc_featured_image) as ImageView
    }
}