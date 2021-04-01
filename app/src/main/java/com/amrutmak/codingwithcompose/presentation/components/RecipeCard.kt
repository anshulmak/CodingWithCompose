package com.amrutmak.codingwithcompose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.animatedVectorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.amrutmak.codingwithcompose.R
import com.amrutmak.codingwithcompose.domain.model.Recipe
import com.amrutmak.codingwithcompose.util.loadPicture

const val DEFAULT_RECIPE_IMAGE = R.drawable.happy_meal

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
){
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(bottom = 6.dp, top = 6.dp)
            .clickable(onClick = onClick)
    ) {
        Column {
            recipe.featuredImage?.let {  url ->
                val image = loadPicture(url = url , defaultImage = DEFAULT_RECIPE_IMAGE).value
                image?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(225.dp),
                        contentScale = ContentScale.Crop
                        )
                }
                /*Image(
                    //painter = painterResource(id = R.drawable.happy_meal),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(225.dp),
                    contentScale = ContentScale.Crop
                )*/
            }
            recipe.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp, 12.dp, 8.dp, 12.dp)
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h6
                    )


                }
            }
        }

    }
}