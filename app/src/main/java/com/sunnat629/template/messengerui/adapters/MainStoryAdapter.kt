package com.sunnat629.template.messengerui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sunnat629.template.messengerui.model.MainStoryModel
import android.graphics.Bitmap
import com.sunnat629.template.messengerui.R


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
        val dr = RoundedBitmapDrawableFactory.create(
            context!!.resources,getCircleBitmap1(BitmapFactory.decodeResource( context!!.resources, R.drawable.sunnat)))

//        viewHolder.mute.setImageResource(mainMsgModel.isMute)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val fullName = view.findViewById(R.id.full_name) as TextView



        val proPic = view.findViewById(R.id.proPic) as ImageView
        val storyPic = view.findViewById(R.id.storyPic) as ImageView

//        val online = view.findViewById(R.id.online) as ImageView
//        val mute = view.findViewById(R.id.mute) as ImageView

    }

    private fun getCircleBitmap1(source: Bitmap): Bitmap {
        val size = Math.min(source.height, source.width)

        val output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)

        val color = Color.RED
        val paint = Paint()
        val rect = Rect(0, 0, size, size)
        val rectF = RectF(rect)

        paint.isAntiAlias = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = color

        canvas.drawOval(rectF, paint)

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(source, rect, rect, paint)

        return output
    }

     fun getRoundedShape(scaleBitmapImage:Bitmap):Bitmap {
 // TODO Auto-generated method stub
  val targetWidth = 50
val targetHeight = 50
val targetBitmap = Bitmap.createBitmap(targetWidth,
targetHeight, Bitmap.Config.ARGB_8888)

val canvas = Canvas(targetBitmap)
val path = Path()
path.addCircle((targetWidth.toFloat() - 1) / 2,
(targetHeight.toFloat() - 1) / 2,
    Math.min(
        targetWidth.toFloat(),
        targetHeight.toFloat()
    ) / 2,
Path.Direction.CCW)

canvas.clipPath(path)
         canvas.drawBitmap(
             scaleBitmapImage,
Rect(0, 0, scaleBitmapImage.width,
scaleBitmapImage.height
),
Rect(0, 0, targetWidth,
targetHeight), null)
return targetBitmap
}

}