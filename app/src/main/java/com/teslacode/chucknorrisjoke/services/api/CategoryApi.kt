package com.teslacode.chucknorrisjoke.services.api

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by adefruandta on 11/22/17.
 */

interface CategoryApi {

    @GET("categories")
    fun categories(): Observable<List<String>>
}
