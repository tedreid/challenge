package com.tedreid.challenge

data class SearchResults (
        val page: Int,
        val total_results: Int,
        val total_pages: Int,
        var results: ArrayList<MovieDetails>
)