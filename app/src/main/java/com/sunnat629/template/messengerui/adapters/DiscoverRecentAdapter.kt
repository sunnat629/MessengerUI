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
import com.sunnat629.template.messengerui.model.DescRecentModel


class DiscoverRecentAdapter(private var context: Context?,
                            private var descRecentModelList: List<DescRecentModel>
):
    RecyclerView.Adapter<DiscoverRecentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.disc_recent, viewGroup, false)

        return ViewHolder(layoutInflater)    }

    override fun getItemCount(): Int {
        return descRecentModelList.size
    }

    fun setItems(descRecentModelList: List<DescRecentModel>) {
        this.descRecentModelList = emptyList()
        this.descRecentModelList = descRecentModelList
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val descFeaturedMode = descRecentModelList[position]

        viewHolder.fullName.text = descFeaturedMode.profileName
        Picasso.get().load(descFeaturedMode.profileImage).into(viewHolder.proPic)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val fullName = view.findViewById(R.id.disc_recent_full_name) as TextView
        val proPic = view.findViewById(R.id.disc_recent_storyPic) as ImageView
    }
}