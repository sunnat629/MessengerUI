package com.sunnat629.template.messengerui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.sunnat629.template.messengerui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment.newInstance(this)
    private val groupFragment = GroupFragment()
    private val cameraFragment = CameraFragment()
    private val gameFragment = GameFragment()
    private val othersFragment = OthersFragment()
    private val fm = supportFragmentManager
    private var active: Fragment = homeFragment


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fm.beginTransaction().hide(active).show(homeFragment).commit()
                active = homeFragment

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_group -> {
                fm.beginTransaction().hide(active).show(groupFragment).commit()
                active = groupFragment

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_camera -> {
                fm.beginTransaction().hide(active).show(cameraFragment).commit()
                active = cameraFragment

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_game -> {
                fm.beginTransaction().hide(active).show(gameFragment).commit()
                active = gameFragment

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_others -> {
                fm.beginTransaction().hide(active).show(othersFragment).commit()
                active = othersFragment

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm.beginTransaction().add(R.id.main_container, homeFragment, "1").commit()
        fm.beginTransaction().add(R.id.main_container, groupFragment, "2").hide(groupFragment).commit()
        fm.beginTransaction().add(R.id.main_container, cameraFragment, "3").hide(cameraFragment).commit()
        fm.beginTransaction().add(R.id.main_container, gameFragment, "4").hide(gameFragment).commit()
        fm.beginTransaction().add(R.id.main_container, othersFragment, "5").hide(othersFragment).commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
