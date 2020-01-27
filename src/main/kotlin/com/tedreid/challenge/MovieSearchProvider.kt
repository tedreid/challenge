package com.tedreid.challenge

import com.tedreid.challenge.MovieDetails

interface MovieSearchProvider {
    fun search(title: String, page: Int? = 1): ArrayList<MovieDetails> {
        return ArrayList<MovieDetails>()
    }
}