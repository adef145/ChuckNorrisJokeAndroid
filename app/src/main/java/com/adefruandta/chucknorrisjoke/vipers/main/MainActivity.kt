package com.adefruandta.chucknorrisjoke.vipers.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.adefruandta.chucknorrisjoke.R
import com.adefruandta.chucknorrisjoke.adapters.category.CategoryAdapter
import com.adefruandta.chucknorrisjoke.vipers.main.MainContract.ViewBehavior
import com.adefruandta.chucknorrisjoke.vipers.random.RandomFragment
import com.adefruandta.viper.activities.ViperDrawerActivity

/**
 * Created by adefruandta on 11/22/17.
 */

class MainActivity : ViperDrawerActivity<RandomFragment, MainContract.Presenter>(), ViewBehavior {

    // region Attributes

    private var drawerMenu: RecyclerView? = null

    // endregion

    // region ViperDrawerActivity

    override fun onCreateFragment(savedInstanceState: Bundle?): RandomFragment? {
        return RandomFragment()
    }

    override fun onCreateDrawerMenu(inflater: LayoutInflater?, navigationView: NavigationView) {
        val view = inflater!!.inflate(R.layout.widget_drawer_menu, navigationView, true)
        drawerMenu = view.findViewById(R.id.drawerMenu)
    }

    override fun onCreatePresenter(savedInstanceState: Bundle?): MainContract.Presenter? {
        return MainPresenter(this, MainInteractor())
    }

    // endregion

    // region View Behavior

    override fun setCategory(category: String) {
        fragment?.setCategory(category)
    }

    override fun setAdapter(categoryAdapter: CategoryAdapter) {
        drawerMenu?.adapter = categoryAdapter
        drawerMenu?.layoutManager = LinearLayoutManager(this)
    }

    // endregion
}
