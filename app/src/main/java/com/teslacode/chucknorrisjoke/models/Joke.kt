package com.teslacode.chucknorrisjoke.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by adefruandta on 11/14/17.
 */

class Joke : Serializable {

    @SerializedName("id")
    var remoteId: String? = null

    @SerializedName("icon_url")
    var iconUrl: String? = null

    @SerializedName("category")
    var category: List<String>? = null

    @SerializedName("value")
    var value: String? = null

    @SerializedName("url")
    var url: String? = null
}
