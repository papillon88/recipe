package qwe.asd.recipe.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import qwe.asd.recipe.services.RecipeService;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    /************************************
    *************************************
    Methods
    *************************************
    ************************************/

    @RequestMapping(value = "/recipe/show/{recipeId}", method = RequestMethod.GET)
    public String showById(@PathVariable String recipeId, Model model){
        model.addAttribute("recipe",recipeService.getRecipeById(Long.valueOf(recipeId)));
        return "show";
    }

    public RecipeService getRecipeService() {
        return recipeService;
    }

    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}
