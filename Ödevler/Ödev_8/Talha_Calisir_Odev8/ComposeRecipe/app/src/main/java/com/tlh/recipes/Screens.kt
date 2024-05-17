package com.tlh.recipes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tlh.recipes.model.Recipe


@Composable
fun RecipeListScreen(
    viewModel: RecipeViewModel = RecipeViewModel(),
    navController: NavController
) {
    val recipes by viewModel.recipes.observeAsState(emptyList())
    var searchQuery by remember { mutableStateOf("") }

    Column {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Recipes") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        LazyColumn {
            items(recipes.filter { it.name.contains(searchQuery, ignoreCase = true) }) { recipe ->
                RecipeRow(recipe, navController)
            }
        }
    }
}

@Composable
fun RecipeRow(recipe: Recipe, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("recipeDetail/${recipe.id}")
            }
            .padding(16.dp)
    ) {
        Text(recipe.name, modifier = Modifier.weight(1f))
        Text("${recipe.caloriesPerServing} cal", modifier = Modifier.weight(1f))
    }
}

@Composable
fun RecipeDetailScreen(
    recipeId: Int,
    viewModel: RecipeViewModel = RecipeViewModel()
) {
    val recipe = checkNotNull(viewModel.recipes.observeAsState().value?.find { it.id == recipeId })

    Column(modifier = Modifier.padding(16.dp)) {
        Text(recipe.name, style = MaterialTheme.typography.bodyLarge)
        Text("Calories per Serving: ${recipe.caloriesPerServing}")
        Text("Ingredients: ${recipe.ingredients.joinToString(", ")}")
        Text("Instructions: ${recipe.instructions.joinToString(" ")}")
        Text("Prep Time: ${recipe.prepTimeMinutes}")
        Text("Prep Time: ${recipe.cookTimeMinutes}")
        Text("Servings: ${recipe.servings}")
        Text("Difficulty: ${recipe.difficulty}")
        Text("Cuisine: ${recipe.cuisine}")
        Text("Calories Per Serving: ${recipe.caloriesPerServing}")
        Text("Rating: ${recipe.rating}")
        Text("Tags: ${recipe.tags}")
    }
}


@Composable
fun MainScreen(
    viewModel: RecipeViewModel = RecipeViewModel()
) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "recipeList") {
        composable("recipeList") { RecipeListScreen(viewModel, navController) }
        composable("recipeDetail/{recipeId}") { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getString("recipeId")?.toInt()
            RecipeDetailScreen(recipeId ?: 0, viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeListScreenPreview() {
    val navController = rememberNavController()
    RecipeListScreen(
        navController = navController
    )
}

@Preview(showBackground = true)
@Composable
fun RecipeRowPreview() {
    val navController = rememberNavController()
    RecipeRow(
        recipe = Recipe(
            1, "Fake Recipe", 100, emptyList(), emptyList(), 1,
            1, 1, "easy", "", emptyList(), 1, "", 3f, 3, emptyList()
        ),
        navController = navController
    )
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailScreenPreview() {
    RecipeDetailScreen(
        recipeId = 1
    )
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
    RecipeDetailScreen(recipeId = 2)
}