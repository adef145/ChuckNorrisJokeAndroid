package com.teslacode.chucknorrisjoke.vipers.main

import android.os.Bundle
import com.teslacode.chucknorrisjoke.adapters.category.CategoryAdapter
import com.teslacode.chucknorrisjoke.vipers.main.MainContract.*
import com.teslacode.viper.contracts.ViperContract
import com.teslacode.viper.presenters.ViperDrawerActivityPresenter

/**
 * Created by adefruandta on 11/22/17.
 */

class MainPresenter(view: ViewBehavior, interactor: Interactor) : ViperDrawerActivityPresenter<ViewBehavior, Interactor, ViperContract.Router>(view, interactor), Presenter, InteractorOutput {

    private val categoryAdapter = CategoryAdapter()

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
        super.onCreate(extras, savedInstanceState)
        categoryAdapter.setOnItemClickListener { _, _, data ->
            view?.setCategory(data!!)
            view?.closeDrawers()
        }
    }

    override fun onPostCreate() {
        super.onPostCreate()
        view?.setAdapter(categoryAdapter)
    }

    // region Output

    override fun setCategories(categories: List<String>) {
        val finalCategories = categories.toMutableList()
        finalCategories.add(0, "all")
        categoryAdapter.data = finalCategories
    }

    // endregion
}
