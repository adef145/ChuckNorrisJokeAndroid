package com.adefruandta.chucknorrisjoke.vipers.random

import android.content.Intent
import android.support.v4.app.Fragment
import com.adefruandta.chucknorrisjoke.vipers.random.RandomContract.Router
import com.adefruandta.viper.routers.ViperRouter

/**
 * Created by adefruandta on 11/27/17.
 */

class RandomRouter(fragment: Fragment) : ViperRouter(fragment), Router {

    // region Router

    override fun share(text: String) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text)

        startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }

    // endregion
}
