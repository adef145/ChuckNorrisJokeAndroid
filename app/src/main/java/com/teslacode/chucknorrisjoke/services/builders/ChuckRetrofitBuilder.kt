package com.teslacode.chucknorrisjoke.services.builders

import com.teslacode.service.builders.RetrofitBuilder

/**
 * Created by adefruandta on 11/14/17.
 */

class ChuckRetrofitBuilder : RetrofitBuilder() {

    override var baseUrl: String = "https://api.chucknorris.io/jokes/"
}
