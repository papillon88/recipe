package qwe.asd.recipe.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import qwe.asd.recipe.commands.RecipeCommand;
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.services.RecipeService;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;


    @RequestMapping(value = "/recipe/{recipeId}", method = RequestMethod.GET)
    public String showRecipeById(@PathVariable String recipeId, Model model){
        model.addAttribute("recipe",recipeService.getRecipeCommandById(Long.valueOf(recipeId)));
        return "showRecipeDetail";
    }


    @RequestMapping(value = {"/recipe/new"}, method = RequestMethod.GET)
    public String showRecipeFormForCreation(Model model){
        model.addAttribute("recipe",new RecipeCommand());
        return "recipeform";
    }


    @RequestMapping(value = {"/recipe/create"},method = RequestMethod.POST)
    public String postSubmitRecipeForm(@ModelAttribute RecipeCommand recipeCommand){
        RecipeCommand recipeCommand1 = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/";
    }


    @RequestMapping(value = {"/recipe/{recipeId}/update"} , method = RequestMethod.GET)
    public String updateRecipeById(@PathVariable String recipeId, Model model){
        //get recipe by id , convert to recipe command and throw to recipeform for update
        model.addAttribute("recipe",recipeService.getRecipeCommandById(Long.valueOf(recipeId)));
        return "recipeform";
    }

    @RequestMapping(value = {"/recipe/{recipeId}/delete"} , method = RequestMethod.GET)
    public String deleteRecipeById(@PathVariable String recipeId){
        recipeService.deleteRecipeById(Long.valueOf(recipeId));
        return "redirect:/";
    }


    /*public RecipeService getRecipeService() {
        return recipeService;
    }*/

    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


}
