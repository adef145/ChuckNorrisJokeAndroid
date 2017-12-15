package com.adefruandta.chucknorrisjoke.vipers.main

import com.adefruandta.chucknorrisjoke.adapters.category.CategoryAdapter
import com.adefruandta.viper.contracts.ViperDrawerActivityContract

/**
 * Created by adefruandta on 11/22/17.
 */

interface MainContract {

    interface ViewBehavior : ViperDrawerActivityContract.ViewBehavior {

        fun setAdapter(categoryAdapter: CategoryAdapter)

        fun setCategory(category: String)
    }

    interface Presenter : ViperDrawerActivityContract.Presenter<ViewBehavior, Interactor, Router>

    interface Interactor : ViperDrawerActivityContract.Interactor

    interface InteractorOutput : ViperDrawerActivityContract.InteractorOutput {

        fun setCategories(categories: List<String>)
    }

    interface Router : ViperDrawerActivityContract.Router
}
