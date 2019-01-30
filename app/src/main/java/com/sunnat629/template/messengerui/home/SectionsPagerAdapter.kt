package com.sunnat629.template.messengerui.home

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import com.sunnat629.template.messengerui.GameFragment
import com.sunnat629.template.messengerui.GroupFragment
import com.sunnat629.template.messengerui.OthersFragment
import com.sunnat629.template.messengerui.R

private val TAB_TITLES = arrayOf(
    R.string.tab_msg,
    R.string.tab_active,
    R.string.tab_group,
    R.string.tab_call
    )

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context?, fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        Log.wtf("*******", "position: $position")
        when (position) {
            0 -> return MainMsgFragment.newInstance()
            1 -> return GroupFragment.newInstance()
            2 -> return GameFragment.newInstance()
            3 -> return OthersFragment.newInstance()

        }
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return HomeFragment.newInstance(context)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context!!.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }
}