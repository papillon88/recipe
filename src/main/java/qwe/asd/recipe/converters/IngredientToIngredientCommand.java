package qwe.asd.recipe.converters;


import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.commands.IngredientCommand;
import qwe.asd.recipe.domains.Ingredient;

@Component
@Getter
@Setter
public class IngredientToIngredientCommand implements Converter<Ingredient,IngredientCommand> {

    @Autowired
    private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @Synchronized
    @Override
    public IngredientCommand convert(Ingredient source) {
        if(source == null)
            return null;

        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setRecipeId(source.getRecipe().getId());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUnitOfMeasureCommand(unitOfMeasureToUnitOfMeasureCommand.convert(source.getUnitOfMeasure()));
        return ingredientCommand;
    }
}
