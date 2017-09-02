package qwe.asd.recipe.services;

import qwe.asd.recipe.commands.RecipeCommand;
import qwe.asd.recipe.domains.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<RecipeCommand> getAllRecipeCommands();
    RecipeCommand getRecipeCommandById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
