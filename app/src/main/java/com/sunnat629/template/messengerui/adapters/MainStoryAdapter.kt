package com.sunnat629.template.messengerui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.sunnat629.template.messengerui.R
import com.sunnat629.template.messengerui.model.MainMsgModel
import com.sunnat629.template.messengerui.model.MainStoryModel
import com.sunnat629.template.messengerui.util.Constants.TIME_FORMAT
import com.sunnat629.template.messengerui.util.MyTextUtil
import com.sunnat629.template.messengerui.util.ValueForDemo
import de.hdodenhof.circleimageview.CircleImageView
import java.text.FieldPosition
import java.text.SimpleDateFormat

class MainStoryAdapter(private var context: Context?,
                       private var mainStoryModelList: List<MainStoryModel>
):
RecyclerView.Adapter<MainStoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.main_story_item, viewGroup, false)

        return ViewHolder(layoutInflater)    }

    override fun getItemCount(): Int {
return mainStoryModelList.size
    }

    fun setItems(mainStoryModelList: List<MainStoryModel>) {
        this.mainStoryModelList = emptyList()
        this.mainStoryModelList = mainStoryModelList
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val mainMsgModel = mainStoryModelList[position]

        viewHolder.fullName.text = mainMsgModel.profileName

//        viewHolder.mute.setImageResource(mainMsgModel.isMute)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val fullName = view.findViewById(R.id.full_name) as TextView

//        val proPic = view.findViewById(R.id.proPic) as CircleImageView
//        val online = view.findViewById(R.id.online) as CircleImageView
//        val mute = view.findViewById(R.id.mute) as ImageView

    }

}