package com.teslacode.chucknorrisjoke.vipers.random

import com.teslacode.chucknorrisjoke.models.Joke
import com.teslacode.viper.contracts.Contract
import com.teslacode.viper.contracts.FragmentContract

/**
 * Created by adefruandta on 11/14/17.
 */

interface RandomContract {

    interface ViewBehavior : FragmentContract.ViewBehavior {

        fun showJoke(joke: Joke)

        fun showError(message: String)
    }

    interface Presenter : FragmentContract.Presenter {

        fun onRandom()

        fun setCategory(category: String)

        fun onShare()

        fun showAbout()
    }

    interface Interactor : FragmentContract.Interactor {

        fun onRandom()

        fun setCategory(category: String)

        fun onShare()
    }

    interface InteractorOutput : FragmentContract.InteractorOutput {

        fun showJoke(joke: Joke?)

        fun shareJoke(joke: Joke)

        fun showError(message: String)

        fun setTitle(categoryJoke: String?)

        fun showProgress()

        fun hideProgress()
    }

    interface Router : Contract.Router {

        fun share(text: String)

        fun showAbout()

        fun showProgress()

        fun hideProgress()
    }
}
