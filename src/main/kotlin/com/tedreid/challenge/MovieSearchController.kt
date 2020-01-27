package com.tedreid.challenge

import org.springframework.web.bind.annotation.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

@RestController
class MovieSearchController(private val movieSearchProvider: MovieSearchProvider) {


    @ResponseBody
    @GetMapping("/{searchString}")
    fun basicGet(@PathVariable searchString : String): String {
        var returnVal = movieSearchProvider.search(searchString)
        return jacksonObjectMapper().writeValueAsString(returnVal)
    }

    @ResponseBody
    @GetMapping("/movies")
    fun searchGet(@RequestParam("search") searchString: String, @RequestParam("page") page: Int? = 1): String {
        var returnVal = movieSearchProvider.search(searchString, page)
        return jacksonObjectMapper().writeValueAsString(returnVal)

    }
}