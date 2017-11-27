package com.teslacode.chucknorrisjoke.vipers.random

import android.os.Bundle
import com.teslacode.chucknorrisjoke.models.Joke
import com.teslacode.chucknorrisjoke.services.repositories.JokeRepository
import com.teslacode.chucknorrisjoke.vipers.random.RandomContract.Interactor
import com.teslacode.viper.interactors.FragmentInteractor

/**
 * Created by adefruandta on 11/14/17.
 */

class RandomInteractor : FragmentInteractor<RandomContract.InteractorOutput>(), Interactor {

    companion object {
        private val JOKE_TAG = "JOKE_TAG"
    }

    var categoryJoke: String? = null

    var joke: Joke? = null

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
        super.onCreate(extras, savedInstanceState)

        joke = savedInstanceState?.getSerializable(JOKE_TAG) as Joke?
    }

    override fun onViewCreated() {
        super.onViewCreated()

        if (joke == null) {
            onRandom()
        }
    }

    override fun onSavedInstanceState(outState: Bundle?) {
        super.onSavedInstanceState(outState)
        outState?.putSerializable(JOKE_TAG, joke)
    }

    override fun onRandom() {
        val jokeRepo = JokeRepository()

        jokeRepo.random(categoryJoke).subscribe({
            joke = it
            output?.showJoke(joke)
        }, {
            output?.showError(it.toString())
        })
    }

    override fun setCategory(category: String) {
        categoryJoke = if (category == "All") {
            null
        } else {
            category
        }
        onRandom()
    }

    override fun onShare() {
        if (joke == null) {
            return
        }

        output?.shareJoke(joke!!)
    }
}
