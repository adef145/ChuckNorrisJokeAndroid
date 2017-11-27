package com.teslacode.chucknorrisjoke.vipers.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.teslacode.chucknorrisjoke.R
import com.teslacode.chucknorrisjoke.adapters.category.CategoryAdapter
import com.teslacode.chucknorrisjoke.vipers.main.MainContract.ViewBehavior
import com.teslacode.chucknorrisjoke.vipers.random.RandomFragment
import com.teslacode.viper.activities.DrawerActivity

/**
 * Created by adefruandta on 11/22/17.
 */

class MainActivity : DrawerActivity<RandomFragment, MainContract.Presenter>(), ViewBehavior {

    private var drawerMenu: RecyclerView? = null

    override fun onCreateFragment(savedInstanceState: Bundle?): RandomFragment? {
        return RandomFragment()
    }

    override fun onCreateDrawerMenu(inflater: LayoutInflater?, navigationView: NavigationView) {
        val view = inflater!!.inflate(R.layout.widget_drawer_menu, navigationView, true)
        drawerMenu = view.findViewById(R.id.drawerMenu)
    }

    override fun setCategory(category: String) {
        fragment?.setCategory(category)
    }

    override fun setAdapter(categoryAdapter: CategoryAdapter) {
        drawerMenu?.adapter = categoryAdapter
        drawerMenu?.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreatePresenter(savedInstanceState: Bundle?): MainContract.Presenter? {
        return MainPresenter(this, MainInteractor())
    }
}
