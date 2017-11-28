package qwe.asd.recipe.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import qwe.asd.recipe.services.RecipeService;

@Slf4j
@Controller
public class IngredientController {

    private RecipeService recipeService;

    @Autowired
    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = {"/recipe/{recipeId}/ingredients"}, method = RequestMethod.GET)
    public String showIngredientsByRecipeId(@PathVariable String recipeId, Model model){
        model.addAttribute("ingredients",recipeService.getRecipeCommandById(Long.valueOf(recipeId)).getIngredients());
        return "showIngredientsDetails";
    }
}
