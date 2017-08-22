package qwe.asd.recipe.converters;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import qwe.asd.recipe.commands.IngredientCommand;
import qwe.asd.recipe.commands.UnitOfMeasureCommand;
import qwe.asd.recipe.domains.Ingredient;
import qwe.asd.recipe.domains.UnitOfMeasure;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    private IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    private UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ingredientCommandToIngredient = new IngredientCommandToIngredient();
        ingredientCommandToIngredient.setUnitOfMeasureCommandToUnitOfMeasure(unitOfMeasureCommandToUnitOfMeasure);
    }


    @Test
    public void testNull() throws Exception {
        MockitoAnnotations.initMocks(this);
        assertNull(ingredientCommandToIngredient.convert(null));
    }

    @Test
    public void convert() throws Exception {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(1L);
        ingredientCommand.setAmount(new BigDecimal(10));
        ingredientCommand.setDescription("flour");

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);
        unitOfMeasure.setUom("cups");

        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(1L);
        unitOfMeasureCommand.setUom("cups");
        ingredientCommand.setUnitOfMeasureCommand(unitOfMeasureCommand);


        Mockito.when(unitOfMeasureCommandToUnitOfMeasure.convert(unitOfMeasureCommand)).thenReturn(unitOfMeasure);

        Ingredient ingredient = ingredientCommandToIngredient.convert(ingredientCommand);
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUnitOfMeasure());
        assertEquals("cups",ingredient.getUnitOfMeasure().getUom());
        assertEquals("flour",ingredient.getDescription());
        assertEquals(new BigDecimal(10),ingredient.getAmount());

    }

    @Test
    public void convertNullUom() throws Exception {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(1L);
        ingredientCommand.setAmount(new BigDecimal(10));
        ingredientCommand.setDescription("flour");
        UnitOfMeasureCommand unitOfMeasureCommand = null;
        ingredientCommand.setUnitOfMeasureCommand(unitOfMeasureCommand);

        Ingredient ingredient = ingredientCommandToIngredient.convert(ingredientCommand);
        assertNotNull(ingredient);
        assertNull(ingredient.getUnitOfMeasure());
        assertEquals("flour",ingredient.getDescription());
        assertEquals(new BigDecimal(10),ingredient.getAmount());
    }

}