package com.teslacode.chucknorrisjoke.services.api

import com.teslacode.chucknorrisjoke.models.Joke
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by adefruandta on 11/14/17.
 */

interface JokeApi {

    @GET("random")
    fun random(@Query("category") category: String?): Observable<Joke>
}
