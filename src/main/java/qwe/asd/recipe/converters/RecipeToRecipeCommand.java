package qwe.asd.recipe.converters;

import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.commands.RecipeCommand;
import qwe.asd.recipe.domains.Recipe;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe,RecipeCommand>{

    @Autowired
    private IngredientToIngredientCommand ingredientToIngredientCommand;
    @Autowired
    private CategoryToCategoryCommand categoryToCategoryCommand;
    @Autowired
    private NoteToNoteCommand noteToNoteCommand;


    @Synchronized
    @Override
    public RecipeCommand convert(Recipe source) {
        if(source == null)
            return null;

        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setDirections(source.getDirections());
        recipeCommand.setId(source.getId());
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setUrl(source.getUrl());


        recipeCommand.setNoteCommand(noteToNoteCommand.convert(source.getNote()));
        if(source.getIngredients().size() > 0 && source.getIngredients() != null){
            source.getIngredients()
                    .forEach(ingredient -> recipeCommand.getIngredients().add(ingredientToIngredientCommand.convert(ingredient)));
        }

        if(source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories()
                    .forEach(category -> recipeCommand.getCategories().add(categoryToCategoryCommand.convert(category)));
        }


        return recipeCommand;
    }
}
