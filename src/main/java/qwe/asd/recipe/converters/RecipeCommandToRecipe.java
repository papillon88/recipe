package qwe.asd.recipe.converters;

import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.commands.RecipeCommand;
import qwe.asd.recipe.domains.Recipe;


@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand,Recipe> {

    @Autowired
    private NoteCommandToNote noteCommandToNote;
    @Autowired
    private IngredientCommandToIngredient ingredientCommandToIngredient;
    @Autowired
    private CategoryCommandToCategory categoryCommandToCategory;

    @Synchronized
    @Override
    public Recipe convert(RecipeCommand source) {
        if(source == null)
            return null;


        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirections(source.getDirections());
        recipe.setUrl(source.getUrl());
        recipe.setSource(source.getSource());
        recipe.setServings(source.getServings());
        recipe.setCookTime(source.getCookTime());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setDescription(source.getDescription());
        recipe.setNote(noteCommandToNote.convert(source.getNoteCommand()));

        if(source.getCategories() != null && source.getCategories().size() > 0)
            source.getCategories().forEach(categoryCommand -> recipe.getCategories().add(categoryCommandToCategory.convert(categoryCommand)));

        if(source.getIngredients() != null && source.getIngredients().size() > 0)
            source.getIngredients().forEach(ingredientCommand -> recipe.getIngredients().add(ingredientCommandToIngredient.convert(ingredientCommand)));

        return recipe;
    }
}
