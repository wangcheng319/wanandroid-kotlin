package com.example.wanandroid_kotlin.activity

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.wanandroid_kotlin.R
import com.example.wanandroid_kotlin.fragment.CollectFragment
import com.example.wanandroid_kotlin.fragment.HomeFragment
import com.example.wanandroid_kotlin.fragment.PersonalFragment
import com.example.wanandroid_kotlin.fragment.ProjectFragment

class MainActivity : AppCompatActivity(),HomeFragment.OnFragmentInteractionListener,ProjectFragment.OnFragmentInteractionListener,
    CollectFragment.OnFragmentInteractionListener,PersonalFragment.OnFragmentInteractionListener{

    override fun onHomeFragmentInteraction(uri: Uri) {
    }

    override fun onCollectFragmentInteraction(uri: Uri) {
    }

    override fun onProjectFragmentInteraction(uri: Uri) {
    }

    override fun onPersonalFragmentInteraction(uri: Uri) {
    }

    private lateinit var homeFragment: HomeFragment
    private lateinit var projectFragment: ProjectFragment
    private lateinit var collectFragment: CollectFragment
    private lateinit var personalFragment: PersonalFragment

    private lateinit var fragmentsList: List<Fragment>

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_personal->{
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        homeFragment = HomeFragment.newInstance("","")
        collectFragment = CollectFragment.newInstance("","")
        projectFragment = ProjectFragment.newInstance("","")
        personalFragment = PersonalFragment.newInstance("","")

        fragmentsList = listOf(homeFragment,collectFragment,projectFragment,personalFragment)

        tabFun(0)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun tabFun(index:Int) {
        var transaction = supportFragmentManager.beginTransaction()
        when(index){
            0->transaction.add(R.id.home_container,fragmentsList[0])
            1->transaction.add(R.id.home_container,fragmentsList[1])
            2->transaction.add(R.id.home_container,fragmentsList[2])
            3->transaction.add(R.id.home_container,fragmentsList[3])
        }

        transaction.commit()
    }
}
