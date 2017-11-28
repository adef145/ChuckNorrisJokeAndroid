package com.teslacode.chucknorrisjoke.vipers.random

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.teslacode.chucknorrisjoke.R
import com.teslacode.chucknorrisjoke.models.Joke
import com.teslacode.chucknorrisjoke.vipers.random.RandomContract.Presenter
import com.teslacode.chucknorrisjoke.vipers.random.RandomContract.ViewBehavior
import com.teslacode.viper.fragments.ViperFragment
import kotlinx.android.synthetic.main.fragment_random.*

/**
 * Created by adefruandta on 11/14/17.
 */

class RandomFragment : ViperFragment<Presenter>(), ViewBehavior {

    // region Attributes

    override var layoutResId: Int = R.layout.fragment_random

    // endregion

    // region Fragment Life Cycle

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRandom.setOnClickListener { presenter?.onRandom() }
        btnShare.setOnClickListener { presenter?.onShare() }
    }

    // endregion

    // region ViperFragment

    override fun onCreatePresenter(savedInstanceState: Bundle?): Presenter {
        return RandomPresenter(this, RandomInteractor(), RandomRouter(this))
    }

    // endregion

    // region ViewBehavior

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    @Suppress("DEPRECATION")
    override fun showJoke(joke: Joke) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvJoke.text = Html.fromHtml(joke.value, Html.FROM_HTML_MODE_LEGACY)
        } else {
            tvJoke.text = Html.fromHtml(joke.value)
        }

        Picasso.with(context).load(joke.iconUrl).into(ivIcon)
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    // endregion

    // region Functionality

    fun setCategory(category: String) {
        presenter?.setCategory(category)
    }

    // endregion
}
