package qwe.asd.recipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qwe.asd.recipe.commands.IngredientCommand;
import qwe.asd.recipe.converters.RecipeToRecipeCommand;
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.repositories.RecipeRepo;

import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private RecipeRepo recipeRepo;
    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Autowired
    public IngredientServiceImpl(RecipeRepo recipeRepo,RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepo = recipeRepo;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        IngredientCommand ingredientCommand;
        Optional<Recipe> recipeOptional = recipeRepo.findById(recipeId);

        Recipe recipe = recipeOptional.get();
        ingredientCommand = recipeToRecipeCommand.convert(recipe).getIngredients()
                .stream()
                .filter(ingredientComm -> ingredientComm.getId() == ingredientId)
                .findFirst().get();

        return ingredientCommand;
    }
}
