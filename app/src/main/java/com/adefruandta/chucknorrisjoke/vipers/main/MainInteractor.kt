package com.adefruandta.chucknorrisjoke.vipers.main

import android.os.Bundle
import com.adefruandta.chucknorrisjoke.services.repositories.CategoryRepository
import com.adefruandta.chucknorrisjoke.vipers.main.MainContract.Interactor
import com.adefruandta.chucknorrisjoke.vipers.main.MainContract.InteractorOutput
import com.adefruandta.viper.interactors.ViperInteractor
import java.util.*

/**
 * Created by adefruandta on 11/22/17.
 */

class MainInteractor : ViperInteractor<InteractorOutput>(), Interactor {

    companion object {
        val CATEGORIES_EXTRAS = "CATEGORIES_EXTRAS"
    }

    private var categories: List<String>? = null

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
        super.onCreate(extras, savedInstanceState)

        categories = savedInstanceState?.getStringArrayList(CATEGORIES_EXTRAS)
    }

    override fun onStart() {
        super.onStart()

        if (categories == null) {
            val categoryRepo = CategoryRepository()
            categoryRepo.categories().subscribe({
                categories = it
                output?.setCategories(categories!!)
            }, {
                it.printStackTrace()
            })
        } else {
            output?.setCategories(categories!!)
        }
    }

    override fun onSavedInstanceState(outState: Bundle?) {
        super.onSavedInstanceState(outState)
        outState?.putStringArrayList(CATEGORIES_EXTRAS, categories as ArrayList<String>)
    }
}
