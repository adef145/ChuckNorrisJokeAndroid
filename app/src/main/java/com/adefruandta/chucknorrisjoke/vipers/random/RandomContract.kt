package com.adefruandta.chucknorrisjoke.vipers.random

import com.adefruandta.chucknorrisjoke.models.Joke
import com.adefruandta.viper.contracts.ViperContract
import com.adefruandta.viper.contracts.ViperFragmentContract

/**
 * Created by adefruandta on 11/14/17.
 */

interface RandomContract {

    interface ViewBehavior : ViperFragmentContract.ViewBehavior {

        fun showJoke(joke: Joke)

        fun showError(message: String)

        fun showProgress()

        fun hideProgress()
    }

    interface Presenter : ViperFragmentContract.Presenter<ViewBehavior, Interactor, Router> {

        fun onRandom()

        fun setCategory(category: String)

        fun onShare()
    }

    interface Interactor : ViperFragmentContract.Interactor {

        fun onRandom()

        fun setCategory(category: String)

        fun onShare()
    }

    interface InteractorOutput : ViperFragmentContract.InteractorOutput {

        fun showJoke(joke: Joke?)

        fun shareJoke(joke: Joke)

        fun showError(message: String)

        fun setTitle(categoryJoke: String?)

        fun showProgress()

        fun hideProgress()
    }

    interface Router : ViperContract.Router {

        fun share(text: String)
    }
}
