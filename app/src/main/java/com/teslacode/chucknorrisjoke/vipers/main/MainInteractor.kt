package com.teslacode.chucknorrisjoke.vipers.main

import com.teslacode.chucknorrisjoke.services.repositories.CategoryRepository
import com.teslacode.viper.interactors.DrawerActivityInteractor

/**
 * Created by adefruandta on 11/22/17.
 */

class MainInteractor : DrawerActivityInteractor<MainContract.InteractorOutput>(), MainContract.Interactor {

    override fun onStart() {
        super.onStart()

        val categoryRepo = CategoryRepository()
        categoryRepo.categories().subscribe({
            output?.setCategories(it)
        }, {
            it.printStackTrace()
        })
    }
}
