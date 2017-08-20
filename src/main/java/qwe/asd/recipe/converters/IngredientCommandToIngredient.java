package qwe.asd.recipe.converters;

import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.commands.IngredientCommand;
import qwe.asd.recipe.domains.Ingredient;


@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand,Ingredient> {

    @Autowired
    private UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;


    @Synchronized
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source == null)
            return null;
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());
        ingredient.setAmount(source.getAmount());
        ingredient.setUnitOfMeasure(unitOfMeasureCommandToUnitOfMeasure.convert(source.getUnitOfMeasureCommand()));
        return ingredient;
    }
}
