package com.tedreid.challenge

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

// this class is too dependent on the specific TMDB implementation. It even has a magic string that belongs in a TMDB config
// Should refactor to make this class match the API spec, and then use an object mapper in the specific TMDB class.

data class MovieDetails (
        @get:JsonProperty("movie_id") @param:JsonProperty("id") val id: Int,
        val title: String,
        @get:JsonIgnore(true) @param:JsonProperty("poster_path")
        val poster_path: String?,
        @get:JsonProperty("poster_image_url") @param:JsonProperty("fqdn_poster_path")
        val fqdn_poster_path: String = "https://image.tmdb.org/t/p/original/$poster_path",
        @get:JsonIgnore(true) @param:JsonProperty("popularity")
        val popularity: Int?,
        @get:JsonIgnore(true) @param:JsonProperty("vote_count")
        val vote_count: Int?,
        @get:JsonProperty("popularity_summary") @param:JsonProperty("pop")
        val pop: String = "%d out of %d".format(popularity, vote_count)
)