package com.amrutmak.codingwithcompose.network.response

import com.amrutmak.codingwithcompose.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(

    @SerializedName("count")
        var count: Int,

    @SerializedName("results")
        var recipes: List<RecipeDto>,
)