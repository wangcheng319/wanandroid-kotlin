package com.example.wanandroid_kotlin.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.wanandroid_kotlin.R
import com.example.wanandroid_kotlin.fragment.CollectFragment
import com.example.wanandroid_kotlin.fragment.HomeFragment
import com.example.wanandroid_kotlin.fragment.PersonalFragment
import com.example.wanandroid_kotlin.fragment.ProjectFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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
                tabFun(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                tabFun(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                tabFun(2)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_personal->{
//                tabFun(3)
                startActivity(Intent(this,LoginOrRegisterActivity::class.java))
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
            0->transaction.replace(R.id.home_container,fragmentsList[0])
            1->transaction.replace(R.id.home_container,fragmentsList[1])
            2->transaction.replace(R.id.home_container,fragmentsList[2])
            3->transaction.replace(R.id.home_container,fragmentsList[3])
        }
        transaction.commit()
    }
}
