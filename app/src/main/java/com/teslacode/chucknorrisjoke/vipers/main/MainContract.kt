package com.teslacode.chucknorrisjoke.vipers.main

import com.teslacode.chucknorrisjoke.adapters.category.CategoryAdapter
import com.teslacode.viper.contracts.DrawerActivityContract

/**
 * Created by adefruandta on 11/22/17.
 */

interface MainContract {

    interface ViewBehavior : DrawerActivityContract.ViewBehavior {

        fun setAdapter(categoryAdapter: CategoryAdapter)

        fun setCategory(category: String)
    }

    interface Presenter : DrawerActivityContract.Presenter

    interface Interactor : DrawerActivityContract.Interactor

    interface InteractorOutput : DrawerActivityContract.InteractorOutput {

        fun setCategories(categories: List<String>)
    }
}
