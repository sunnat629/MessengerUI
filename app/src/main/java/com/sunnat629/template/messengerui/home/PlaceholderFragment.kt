package com.sunnat629.template.messengerui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunnat629.template.messengerui.R
import com.sunnat629.template.messengerui.adapters.MainMsgAdapter
import com.sunnat629.template.messengerui.model.MainMsgModel
import com.sunnat629.template.messengerui.util.ValueForDemo
import java.util.*

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

//    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java).apply {
//            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.home_fragment, container, false)

        return root
    }

    private fun storyRecycleView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun messageRecycleView(root: View) {
        val msgList = root.findViewById(R.id.msgList) as RecyclerView
        msgList.layoutManager = LinearLayoutManager(activity)
        msgList.setHasFixedSize(true)
        msgList.adapter = MainMsgAdapter(activity, getProfile())
    }

    private fun getProfile(): List<MainMsgModel>{
        for (count in 1..100){
            mainMsgModelList.add(MainMsgModel(
                activity!!.getString(R.string.full_name),
                R.drawable.sunnat,
                activity!!.getString(R.string.last_msg),
                Date(System.currentTimeMillis()),
                ValueForDemo.getRandomBoolean(),
                ValueForDemo.getRandomBoolean(),
                ValueForDemo.getRandomBoolean()
            ))
        }

        return mainMsgModelList
    }

    private val mainMsgModelList: ArrayList<MainMsgModel> = ArrayList()


    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}