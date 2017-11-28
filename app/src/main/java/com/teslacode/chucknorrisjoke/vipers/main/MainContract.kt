package com.teslacode.chucknorrisjoke.vipers.main

import com.teslacode.chucknorrisjoke.adapters.category.CategoryAdapter
import com.teslacode.viper.contracts.ViperDrawerActivityContract

/**
 * Created by adefruandta on 11/22/17.
 */

interface MainContract {

    interface ViewBehavior : ViperDrawerActivityContract.ViewBehavior {

        fun setAdapter(categoryAdapter: CategoryAdapter)

        fun setCategory(category: String)
    }

    interface Presenter : ViperDrawerActivityContract.Presenter

    interface Interactor : ViperDrawerActivityContract.Interactor

    interface InteractorOutput : ViperDrawerActivityContract.InteractorOutput {

        fun setCategories(categories: List<String>)
    }
}
