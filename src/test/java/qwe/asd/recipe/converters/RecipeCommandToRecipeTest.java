package qwe.asd.recipe.converters;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import qwe.asd.recipe.commands.*;
import qwe.asd.recipe.domains.*;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

    private RecipeCommandToRecipe recipeCommandToRecipe;

    @Mock
    private NoteCommandToNote noteCommandToNote;
    @Mock
    private IngredientCommandToIngredient ingredientCommandToIngredient;
    @Mock
    private CategoryCommandToCategory categoryCommandToCategory;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeCommandToRecipe = new RecipeCommandToRecipe();
        recipeCommandToRecipe.setNoteCommandToNote(noteCommandToNote);
        recipeCommandToRecipe.setCategoryCommandToCategory(categoryCommandToCategory);
        recipeCommandToRecipe.setIngredientCommandToIngredient(ingredientCommandToIngredient);
    }

    @Test
    public void testNull() throws Exception{
        assertNull(recipeCommandToRecipe.convert(null));
    }

    @Test
    public void convert() throws Exception {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setDescription("chicken grill");
        recipeCommand.setCookTime(30);
        recipeCommand.setPrepTime(20);

        NoteCommand noteCommand = new NoteCommand();
        noteCommand.setId(1L);
        recipeCommand.setNoteCommand(noteCommand);

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(1L);
        recipeCommand.getCategories().add(categoryCommand);

        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setUom("teaspoon");

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setUnitOfMeasureCommand(unitOfMeasureCommand);
        recipeCommand.getIngredients().add(ingredientCommand);


        Mockito.when(noteCommandToNote.convert(Matchers.any(NoteCommand.class))).thenReturn(new Note("sample note"));
        Mockito.when(ingredientCommandToIngredient.convert(Matchers.eq(ingredientCommand))).thenReturn(new Ingredient(new UnitOfMeasure("sample teaspoon")));
        Mockito.when(categoryCommandToCategory.convert(Matchers.eq(categoryCommand))).thenReturn(new Category("sample category"));

        Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);
        assertNotNull(recipe);
        assertNotNull(recipe.getCategories().iterator().next());
        assertEquals("sample note",recipe.getNote().getRecipeNotes());
        assertEquals("sample teaspoon",recipe.getIngredients().iterator().next().getUnitOfMeasure().getUom());
        assertEquals("sample category",recipe.getCategories().iterator().next().getDescription());
        assertEquals(Integer.valueOf(30),recipe.getCookTime());
        assertEquals(Integer.valueOf(20),recipe.getPrepTime());
        assertEquals("chicken grill",recipe.getDescription());
    }

}