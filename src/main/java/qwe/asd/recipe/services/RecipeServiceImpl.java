package qwe.asd.recipe.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.repositories.RecipeRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;

    /************************************
    *************************************
    Constructors
    *************************************
    ************************************/

    public RecipeServiceImpl(RecipeRepo recipeRepo){
        this.recipeRepo = recipeRepo;
        log.debug("executing recipe service impl constructor");
    }

    @Override
    public Set<Recipe> getAllRecipes() {
        log.debug("executing recipe service impl");
        Set<Recipe> recipes = new HashSet<>();
        System.out.println("is NULL ?" + recipeRepo != null);
        recipeRepo.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepo.findById(id);
        if(!recipeOptional.isPresent())
            throw new RuntimeException("Recipe NOT found");
        return recipeOptional.get();
    }


}
