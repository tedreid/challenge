package com.tedreid.challenge

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component("MovieSearchProvider")
class TMDBSearchProvider : MovieSearchProvider {
    // TODO: put the magic strings in a config file
    val baseURL: String = "https://api.themoviedb.org/3/search/movie?api_key=%s&language=en-US&query=%s&page=%d&include_adult=false"
    val apiKey: String = "d5db0f68baac2484a363329494067332"
    override fun search(title: String, page: Int?): ArrayList<MovieDetails> {
        val searchURL = baseURL.format(apiKey, title, page)
        val response = RestTemplate().getForObject(searchURL, SearchResults::class.java)
        if (response != null) {
            return response.results
        } else {
            return ArrayList<MovieDetails>()
        }
    }
}
