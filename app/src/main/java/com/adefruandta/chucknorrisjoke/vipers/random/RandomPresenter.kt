package com.adefruandta.chucknorrisjoke.vipers.random

import android.text.TextUtils
import com.adefruandta.chucknorrisjoke.R
import com.adefruandta.chucknorrisjoke.models.Joke
import com.adefruandta.chucknorrisjoke.vipers.random.RandomContract.*
import com.adefruandta.viper.presenters.ViperFragmentPresenter

/**
 * Created by adefruandta on 11/14/17.
 */

class RandomPresenter(view: ViewBehavior, interactor: Interactor, router: Router) : ViperFragmentPresenter<ViewBehavior, Interactor, Router>(view, interactor, router), Presenter, InteractorOutput {

    // region Presenter

    override fun setCategory(category: String) {
        interactor?.setCategory(category)
    }

    override fun onRandom() {
        interactor?.onRandom()
    }

    override fun onShare() {
        interactor?.onShare()
    }

    // endregion

    // region Output

    override fun showJoke(joke: Joke?) {
        if (joke == null) {
            return
        }

        view?.showJoke(joke)
    }


    override fun setTitle(categoryJoke: String?) {
        if (TextUtils.isEmpty(categoryJoke)) {
            view?.setTitle(R.string.app_name)
        } else {
            view?.setTitle(categoryJoke)
        }
    }

    override fun showProgress() {
        view?.showProgress()
    }

    override fun hideProgress() {
        view?.hideProgress()
    }

    override fun showError(message: String) {
        view?.showError(message)
    }

    override fun shareJoke(joke: Joke) {
        val text = joke.value + "\n\n" + joke.url
        router?.share(text)
    }

    // endregion
}
