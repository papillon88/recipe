package qwe.asd.recipe.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import qwe.asd.recipe.domains.Category;
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.domains.UnitOfMeasure;
import qwe.asd.recipe.repositories.CategoryRepo;
import qwe.asd.recipe.repositories.UnitOfMeasureRepo;
import qwe.asd.recipe.services.RecipeService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Controller
public class IndexController {


    @Autowired
    private RecipeService recipeService;

    public IndexController(RecipeService recipeService){
        this.recipeService = recipeService;
    }


    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        Set<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes",recipes);
        log.debug("******************************loading controller");
        return "index";
    }
}
