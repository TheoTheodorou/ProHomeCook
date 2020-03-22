package com.example.phc.ViewModels;

import android.content.Context;

import com.example.phc.DataService;
import com.example.phc.MainActivity;
import com.example.phc.Models.Recipe;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

public class UserRecipesViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    public List<Recipe> recipeList;
    public DataService dataService;
    public RecyclerView userRecipesRecyclerView;

    public void init(MainActivity mainActivity){
        recipeList = createTempRecipeList();
//        get recipe data from username here
//        might look something like this
//        dataService = mainActivity.dataService;
//        recipeList = dataService.GetUserRecipes(mainActivity.currentUser);
        }

        public List<Recipe> createTempRecipeList(){
            List<Recipe> tempRecipeList = new ArrayList<Recipe>();

            List<String> ingredients = new ArrayList<String>();
            ingredients.add("Beef Patty");
            ingredients.add("Burger Bun");
            ingredients.add("Cheese");

            Recipe tempRecipe = new Recipe();
            tempRecipe.name=("Hamburger");
            tempRecipe.ingredients = ingredients;
            tempRecipe.imageUrl = "https://www.mcdonalds.com/is/image/content/dam/uk/nfl/nutrition/nfl-product/product/products/mcdonalds-Hamburger.jpg";

            tempRecipeList.add(tempRecipe);
            return recipeList;
        }

}
