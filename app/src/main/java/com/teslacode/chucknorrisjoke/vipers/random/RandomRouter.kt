package com.teslacode.chucknorrisjoke.vipers.random

import android.content.Intent
import android.support.v4.app.DialogFragment
import com.teslacode.chucknorrisjoke.vipers.overlayprogressbar.OverlayProgressBar
import com.teslacode.chucknorrisjoke.vipers.random.RandomContract.Router
import com.teslacode.viper.routers.ViperRouter

/**
 * Created by adefruandta on 11/27/17.
 */

class RandomRouter(fragment: RandomFragment) : ViperRouter(fragment), Router {

    companion object {
        val OVERLAY_PROGRESS_BAR_TAG = "OVERLAY_PROGRESS_BAR_TAG"
    }

    override fun share(text: String) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text)

        startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }

    override fun showAbout() {

    }

    override fun showProgress() {
        val progress = OverlayProgressBar()
        progress.show(fragment?.fragmentManager, OVERLAY_PROGRESS_BAR_TAG)
    }

    override fun hideProgress() {
        (fragment?.fragmentManager?.findFragmentByTag(OVERLAY_PROGRESS_BAR_TAG) as DialogFragment).dismiss()
    }
}
