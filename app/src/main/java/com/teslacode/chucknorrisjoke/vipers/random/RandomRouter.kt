package com.teslacode.chucknorrisjoke.vipers.random

import android.content.Intent
import android.support.v4.app.Fragment
import com.teslacode.chucknorrisjoke.vipers.random.RandomContract.Router
import com.teslacode.viper.routers.ViperRouter

/**
 * Created by adefruandta on 11/27/17.
 */

class RandomRouter(fragment: Fragment) : ViperRouter(fragment), Router {

    override fun share(text: String) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text)

        startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }
}
