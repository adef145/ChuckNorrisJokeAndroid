package com.adefruandta.chucknorrisjoke

import com.adefruandta.chucknorrisjoke.services.builders.ChuckRetrofitBuilder
import com.adefruandta.service.builders.RetrofitBuilder

/**
 * Created by adefruandta on 11/14/17.
 */

class Application : android.app.Application() {

    // region Application Life Cycle

    override fun onCreate() {
        super.onCreate()

        RetrofitBuilder.builder = ChuckRetrofitBuilder()
    }

    // endregion
}
