package com.amrutmak.codingwithcompose.di

import com.amrutmak.codingwithcompose.network.RecipeService
import com.amrutmak.codingwithcompose.network.model.RecipeDtoMapper
import com.amrutmak.codingwithcompose.repository.RecipeRepository
import com.amrutmak.codingwithcompose.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeMapper: RecipeDtoMapper,
    ): RecipeRepository {
        return RecipeRepository_Impl(
            recipeService = recipeService,
            mapper = recipeMapper
        )
    }
}

