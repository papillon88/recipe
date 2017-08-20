package qwe.asd.recipe.converters;

import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.commands.IngredientCommand;
import qwe.asd.recipe.domains.Ingredient;


@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand,Ingredient> {

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source == null)
            return null;
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());
        ingredient.setAmount(source.getAmount());
        ingredient.setUnitOfMeasure(source.getUnitOfMeasure());
        return ingredient;
    }
}
