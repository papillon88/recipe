package qwe.asd.recipe.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import qwe.asd.recipe.services.IngredientService;
import qwe.asd.recipe.services.RecipeService;

@Slf4j
@Controller
public class IngredientController {

    private RecipeService recipeService;
    private IngredientService ingredientService;

    @Autowired
    public IngredientController(RecipeService recipeService,IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping(value = {"/recipe/{recipeId}/ingredients"}, method = RequestMethod.GET)
    public String showIngredientsByRecipeId(@PathVariable String recipeId, Model model){
        model.addAttribute("ingredients",recipeService.getRecipeCommandById(Long.valueOf(recipeId)).getIngredients());
        return "showIngredientsDetails";
    }


    @RequestMapping(value = {"/recipe/{recipeId}/ingredient/{ingredientId}/show"}, method = RequestMethod.GET)
    public String showIngredientByIngredientIDAndRecipeId(@PathVariable String recipeId,
                                                          @PathVariable String ingredientId,Model model){
        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId),Long.valueOf(ingredientId)));
        return "showIndividualIngredient";
    }
}
