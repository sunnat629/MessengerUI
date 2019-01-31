package com.sunnat629.template.messengerui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.sunnat629.template.messengerui.R
import com.sunnat629.template.messengerui.adapters.*
import com.sunnat629.template.messengerui.util.ValueForDemo.profileFeaturedList
import com.sunnat629.template.messengerui.util.ValueForDemo.profilePopularList
import com.sunnat629.template.messengerui.util.ValueForDemo.profileRecentList


class DiscoverFragment : Fragment() {


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
        val root = inflater.inflate(R.layout.discover_body, container, false)

        initLayout(root)
        recentList()
        featuredList()
        popularList()

        games.setOnClickListener {
            games.background = activity!!.getDrawable(R.drawable.button_curve)
            business.background = activity!!.getDrawable(R.drawable.button_curve_trans)
        }
        business.setOnClickListener {
            business.background = activity!!.getDrawable(R.drawable.button_curve)
            games.background = activity!!.getDrawable(R.drawable.button_curve_trans)
        }


        return root
    }

    private fun initLayout(root: View) {
        discRecentList = root.findViewById(R.id.disc_recent_list)
        discFeaturedList = root.findViewById(R.id.disc_featured_list)
        discPopularList = root.findViewById(R.id.disc_popular_list)

        business = root.findViewById(R.id.business)
        games = root.findViewById(R.id.games)
        search = root.findViewById(R.id.search_layout)

    }
    private lateinit var discRecentList:RecyclerView
    private lateinit var discFeaturedList:RecyclerView
    private lateinit var discPopularList:RecyclerView

    private lateinit var business:TextView
    private lateinit var games:TextView
    private lateinit var search: LinearLayout



    private fun recentList() {
        discRecentList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        discRecentList.setHasFixedSize(true)
        discRecentList.isNestedScrollingEnabled = false
        discRecentList.adapter = DiscoverRecentAdapter(activity, profileRecentList(activity))
    }

    private fun featuredList() {
        discFeaturedList.layoutManager = LinearLayoutManager(activity)
        discFeaturedList.setHasFixedSize(true)
        discFeaturedList.isNestedScrollingEnabled = false
        discFeaturedList.adapter = DiscoverFeaturedAdapter(activity, profileFeaturedList(activity))
    }

    private fun popularList() {
        discPopularList.layoutManager = LinearLayoutManager(activity)
        discPopularList.isNestedScrollingEnabled = false
        discPopularList.setHasFixedSize(true)
        discPopularList.adapter = DiscoverPopularAdapter(activity, profilePopularList(activity))
    }


    companion object {
        @JvmStatic
        fun newInstance() = DiscoverFragment()
    }
}
