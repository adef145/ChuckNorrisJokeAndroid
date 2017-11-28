package com.teslacode.chucknorrisjoke.services.repositories

import com.teslacode.chucknorrisjoke.services.api.CategoryApi
import com.teslacode.service.repositories.Repository
import io.reactivex.Observable
import retrofit2.Retrofit

/**
 * Created by adefruandta on 11/22/17.
 */

class CategoryRepository : Repository<CategoryApi>() {

    // region Repository

    override fun onCreateApi(retrofit: Retrofit): CategoryApi? {
        return retrofit.create(CategoryApi::class.java)
    }

    // endregion

    // region Functionality

    fun categories(): Observable<List<String>> {
        return observe(api!!.categories())
    }

    // endregion
}
