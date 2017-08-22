package qwe.asd.recipe.converters;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import qwe.asd.recipe.commands.IngredientCommand;
import qwe.asd.recipe.commands.UnitOfMeasureCommand;
import qwe.asd.recipe.domains.Ingredient;
import qwe.asd.recipe.domains.UnitOfMeasure;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {


    private IngredientToIngredientCommand ingredientToIngredientCommand;

    @Mock
    private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ingredientToIngredientCommand = new IngredientToIngredientCommand();
        ingredientToIngredientCommand.setUnitOfMeasureToUnitOfMeasureCommand(unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void convert() throws Exception {
        assertNull(ingredientToIngredientCommand.convert(null));

        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setDescription("olive oil");
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);
        unitOfMeasure.setUom("cups");
        ingredient.setUnitOfMeasure(unitOfMeasure);

        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(1L);
        unitOfMeasureCommand.setUom("cups");

        Mockito.when(unitOfMeasureToUnitOfMeasureCommand.convert(unitOfMeasure)).thenReturn(unitOfMeasureCommand);

        IngredientCommand ingredientCommand = ingredientToIngredientCommand.convert(ingredient);
        assertNotNull(ingredientCommand);
        assertNotNull(ingredientCommand.getUnitOfMeasureCommand());
        assertEquals("cups",ingredientCommand.getUnitOfMeasureCommand().getUom());
        assertEquals("olive oil",ingredientCommand.getDescription());


    }

}