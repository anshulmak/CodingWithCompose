package com.amrutmak.codingwithcompose.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.amrutmak.codingwithcompose.domain.model.Recipe
import com.amrutmak.codingwithcompose.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment: Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("VIEWMODEL: ${viewModel}")
        println("VIEWMODEL: repository: ${viewModel.getRepo()}")
        println("VIEWMODEL: token: ${viewModel.getAuthToken()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val recipes = viewModel.recipes.value

                LazyColumn(
                    modifier = Modifier.padding(10.dp)
                ){
                    itemsIndexed(
                        items = recipes
                    ){ index, recipe ->
                        RecipeCard(recipe = recipe,onClick = {
                            Toast.makeText(requireContext(),recipe.title,Toast.LENGTH_SHORT).show()
                        })
                    }
                }
            }
        }
    }
}





















