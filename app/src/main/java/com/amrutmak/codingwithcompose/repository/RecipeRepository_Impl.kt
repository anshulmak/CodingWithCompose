package com.amrutmak.codingwithcompose.repository

import com.amrutmak.codingwithcompose.domain.model.Recipe
import com.amrutmak.codingwithcompose.network.RecipeService
import com.amrutmak.codingwithcompose.network.model.RecipeDtoMapper
import com.amrutmak.codingwithcompose.repository.RecipeRepository

class RecipeRepository_Impl (
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper,
): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token = token, page = page, query = query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token = token, id))
    }

}