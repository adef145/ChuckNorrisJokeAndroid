package com.teslacode.chucknorrisjoke.vipers.overlayprogressbar

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.teslacode.chucknorrisjoke.R
import com.teslacode.viper.contracts.DialogFragmentContract.Presenter
import com.teslacode.viper.fragments.ViperDialogFragment

/**
 * Created by adefruandta on 11/28/17.
 */

class OverlayProgressBar : ViperDialogFragment<Presenter>() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        isCancelable = false
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater?.inflate(R.layout.fragment_overlay_progress_bar, container, false)
    }
}
