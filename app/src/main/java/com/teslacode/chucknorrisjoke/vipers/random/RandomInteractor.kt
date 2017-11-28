package com.teslacode.chucknorrisjoke.vipers.random

import android.os.Bundle
import com.teslacode.chucknorrisjoke.models.Joke
import com.teslacode.chucknorrisjoke.services.repositories.JokeRepository
import com.teslacode.chucknorrisjoke.vipers.random.RandomContract.Interactor
import com.teslacode.viper.interactors.ViperFragmentInteractor

/**
 * Created by adefruandta on 11/14/17.
 */

class RandomInteractor : ViperFragmentInteractor<RandomContract.InteractorOutput>(), Interactor {

    companion object {
        private val JOKE_EXTRAS = "JOKE_EXTRAS"
        private val CATEGORY_JOKE_EXTRAS = "CATEGORY_JOKE_EXTRAS"
    }

    // region Attributes

    private var categoryJoke: String? = null

    private var joke: Joke? = null

    // endregion

    // region ViperFragmentInteractor

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
        super.onCreate(extras, savedInstanceState)

        joke = savedInstanceState?.getSerializable(JOKE_EXTRAS) as Joke?
        categoryJoke = savedInstanceState?.getString(CATEGORY_JOKE_EXTRAS)
    }

    override fun onViewCreated() {
        super.onViewCreated()

        output?.hideProgress()

        if (joke == null) {
            onRandom()
        } else {
            output?.showJoke(joke)
        }

        output?.setTitle(categoryJoke)
    }

    override fun onSavedInstanceState(outState: Bundle?) {
        super.onSavedInstanceState(outState)
        outState?.putSerializable(JOKE_EXTRAS, joke)
        outState?.putString(CATEGORY_JOKE_EXTRAS, categoryJoke)
    }

    // endregion

    // region Interactor

    override fun onRandom() {
        val jokeRepo = JokeRepository()

        output?.showProgress()

        jokeRepo.random(categoryJoke).subscribe({
            joke = it
            output?.showJoke(joke)
            output?.hideProgress()
        }, {
            output?.showError(it.toString())
            output?.hideProgress()
        })
    }

    override fun setCategory(category: String) {
        categoryJoke = if (category == "all") {
            null
        } else {
            category
        }

        output?.setTitle(categoryJoke)
        onRandom()
    }

    override fun onShare() {
        if (joke == null) {
            return
        }

        output?.shareJoke(joke!!)
    }

    // endregion
}
