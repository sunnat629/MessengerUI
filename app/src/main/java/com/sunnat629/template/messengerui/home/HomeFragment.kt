package com.sunnat629.template.messengerui.home

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunnat629.template.messengerui.MainActivity
import com.sunnat629.template.messengerui.R
import com.sunnat629.template.messengerui.adapters.MainMsgAdapter
import com.sunnat629.template.messengerui.adapters.MainStoryAdapter
import com.sunnat629.template.messengerui.model.MainMsgModel
import com.sunnat629.template.messengerui.model.MainStoryModel
import com.sunnat629.template.messengerui.util.ValueForDemo
import java.util.*


class HomeFragment : Fragment() {

//    private lateinit var viewModel: HomeViewModel
    private val mainMsgModelList: ArrayList<MainMsgModel> = ArrayList()
    private val mainStoryModelList: ArrayList<MainStoryModel> = ArrayList()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.main_fragment, container, false)
        sectionsPagerAdapterSet(root)
        fabButton(root)
//        storyRecycleView(root)
//        messageRecycleView(root)

        return root
    }


    private fun sectionsPagerAdapterSet(root: View) {

        Log.wtf("*******", "position:")

        val sectionsPagerAdapter =
            SectionsPagerAdapter(myContext, fm)
        val viewPager: ViewPager = root.findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = root.findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }

    private fun fabButton(root: View) {
        val fab = root.findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun storyRecycleView(root: View) {
        val storyList = root.findViewById(R.id.storyList) as RecyclerView
        storyList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        storyList.setHasFixedSize(true)
        storyList.adapter = MainStoryAdapter(activity, getProfileForStory())
    }

    private fun messageRecycleView(root: View) {
        val msgList = root.findViewById(R.id.msgList) as RecyclerView
        msgList.layoutManager = LinearLayoutManager(activity)
        msgList.setHasFixedSize(true)
        msgList.adapter = MainMsgAdapter(activity, getProfile())
    }

    private fun getProfile(): List<MainMsgModel>{
        for (count in 1..100){

            mainMsgModelList.add(
                MainMsgModel(
                    activity!!.getString(R.string.full_name),
                    R.drawable.sunnat,
                    activity!!.getString(R.string.last_msg),
                    Date(System.currentTimeMillis()),
                    ValueForDemo.getRandomBoolean(),
                    ValueForDemo.getRandomBoolean(),
                    ValueForDemo.getRandomBoolean()
                )
            )
        }

        return mainMsgModelList
    }

    private fun getProfileForStory(): List<MainStoryModel>{
        for (count in 1..100){
            mainStoryModelList.add(
                MainStoryModel(
                    activity!!.getString(R.string.full_name),
                    R.drawable.sunnat,
                    R.drawable.sunnat,
                    ValueForDemo.getRandomBoolean()
                )
            )
        }

        return mainStoryModelList
    }

    companion object {
        private var fm:FragmentManager?=null
        private var myContext: MainActivity?= null

        @JvmStatic
        fun newInstance(context: Context?): HomeFragment{
            myContext = context as MainActivity?
            fm = myContext!!.supportFragmentManager

            return HomeFragment()
        }
    }
}
