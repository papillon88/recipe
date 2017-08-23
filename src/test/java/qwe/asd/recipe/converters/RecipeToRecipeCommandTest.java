package qwe.asd.recipe.converters;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import qwe.asd.recipe.commands.*;
import qwe.asd.recipe.domains.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipeToRecipeCommandTest {


    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    private NoteToNoteCommand noteToNoteCommand;
    @Mock
    private IngredientToIngredientCommand ingredientToIngredientCommand;
    @Mock
    private CategoryToCategoryCommand categoryToCategoryCommand;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeToRecipeCommand = new RecipeToRecipeCommand();
        recipeToRecipeCommand.setNoteToNoteCommand(noteToNoteCommand);
        recipeToRecipeCommand.setCategoryToCategoryCommand(categoryToCategoryCommand);
        recipeToRecipeCommand.setIngredientToIngredientCommand(ingredientToIngredientCommand);
    }

    @Test
    public void testNull() throws Exception{
        assertNull(recipeToRecipeCommand.convert(null));
    }

    @Test
    public void convert() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setDescription("chicken grill");
        recipe.setCookTime(30);

        Note note = new Note();
        note.setId(1L);
        recipe.setNote(note);

        Category category = new Category();
        category.setId(1L);
        recipe.getCategories().add(category);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setUom("teaspoon");

        Ingredient ingredient = new Ingredient();
        ingredient.setUnitOfMeasure(unitOfMeasure);
        recipe.getIngredients().add(ingredient);


        Mockito.when(noteToNoteCommand.convert(Matchers.any(Note.class))).thenReturn(new NoteCommand(2L));
        Mockito.when(ingredientToIngredientCommand.convert(Matchers.eq(ingredient))).thenReturn(new IngredientCommand(new UnitOfMeasureCommand("teaspoon")));
        Mockito.when(categoryToCategoryCommand.convert(Matchers.eq(category))).thenReturn(new CategoryCommand(1L));

        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);
        assertNotNull(recipeCommand);
        assertNotNull(recipeCommand.getCategories());
        assertEquals(Long.valueOf(1L),recipeCommand.getCategories().iterator().next().getId());
        assertEquals(Long.valueOf(2L),recipeCommand.getNoteCommand().getId());
        assertEquals("teaspoon",recipeCommand.getIngredients().iterator().next().getUnitOfMeasureCommand().getUom());

    }

}