package com.sunnat629.template.messengerui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sunnat629.template.messengerui.R
import com.sunnat629.template.messengerui.model.MainMsgModel
import com.sunnat629.template.messengerui.util.Constants.TIME_FORMAT
import com.sunnat629.template.messengerui.util.MyTextUtil
import com.sunnat629.template.messengerui.util.ValueForDemo
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat

class MainMsgAdapter(private var context: Context?,
                     private var mainMsgModelList: List<MainMsgModel>
):
RecyclerView.Adapter<MainMsgAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.main_msg_item, viewGroup, false)

        return ViewHolder(layoutInflater)    }

    override fun getItemCount(): Int {
return mainMsgModelList.size
    }

    fun setItems(postList: List<MainMsgModel>) {
        this.mainMsgModelList = emptyList()
        this.mainMsgModelList = postList
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val mainMsgModel = mainMsgModelList[position]

        viewHolder.fullName.text = mainMsgModel.profileName
        viewHolder.lastMsg.text = MyTextUtil.getLastMsg(ValueForDemo.getRandomBoolean(), mainMsgModel.lastMsg)
        viewHolder.dateTime.text = SimpleDateFormat(TIME_FORMAT).format(mainMsgModel.time).toString()

//        viewHolder.mute.setImageResource(mainMsgModel.isMute)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val fullName = view.findViewById(R.id.fullName) as TextView
        val lastMsg = view.findViewById(R.id.lastMsg) as TextView
        val dateTime = view.findViewById(R.id.dateTime) as TextView

//        val proPic = view.findViewById(R.id.proPic) as CircleImageView
//        val isOnline = view.findViewById(R.id.isOnline) as CircleImageView

    }

}