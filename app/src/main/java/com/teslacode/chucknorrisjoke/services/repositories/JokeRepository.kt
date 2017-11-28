package com.teslacode.chucknorrisjoke.services.repositories

import com.teslacode.chucknorrisjoke.models.Joke
import com.teslacode.chucknorrisjoke.services.api.JokeApi
import com.teslacode.service.repositories.Repository
import io.reactivex.Observable
import retrofit2.Retrofit

/**
 * Created by adefruandta on 11/14/17.
 */

class JokeRepository : Repository<JokeApi>() {

    // region Repository

    override fun onCreateApi(retrofit: Retrofit): JokeApi? {
        return retrofit.create(JokeApi::class.java)
    }

    // endregion

    // region Functionality

    fun random(category: String? = null): Observable<Joke> {
        return observe(api!!.random(category))
    }

    // endregion
}
