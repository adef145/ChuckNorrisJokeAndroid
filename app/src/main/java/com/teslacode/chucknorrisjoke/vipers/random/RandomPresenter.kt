package com.teslacode.chucknorrisjoke.vipers.random

import com.teslacode.chucknorrisjoke.R
import com.teslacode.chucknorrisjoke.models.Joke
import com.teslacode.chucknorrisjoke.vipers.random.RandomContract.*
import com.teslacode.viper.presenters.FragmentPresenter

/**
 * Created by adefruandta on 11/14/17.
 */

class RandomPresenter(view: ViewBehavior, interactor: Interactor, router: Router) : FragmentPresenter<ViewBehavior, Interactor, Router>(view, interactor, router), Presenter, InteractorOutput {

    override fun showJoke(joke: Joke?) {
        if (joke == null) {
            return
        }

        view?.showJoke(joke)
    }

    override fun showError(message: String) {
        view?.showError(message)
    }

    override fun setCategory(category: String) {
        interactor?.setCategory(category)
        if (category == "All") {
            view?.setTitle(R.string.app_name)
        } else {
            view?.setTitle(category)
        }
    }

    override fun onRandom() {
        interactor?.onRandom()
    }

    override fun onShare() {
        interactor?.onShare()
    }

    override fun shareJoke(joke: Joke) {
        val text = joke.value + "\n\n" + joke.url
        router?.share(text)
    }
}
