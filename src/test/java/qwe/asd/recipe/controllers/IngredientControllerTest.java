package qwe.asd.recipe.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import qwe.asd.recipe.commands.IngredientCommand;
import qwe.asd.recipe.commands.RecipeCommand;
import qwe.asd.recipe.services.IngredientService;
import qwe.asd.recipe.services.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class IngredientControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    IngredientService ingredientService;
    @Mock
    Model model;

    IngredientController ingredientController;
    MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ingredientController = new IngredientController(recipeService,ingredientService);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }

    @Test
    public void showIngredientsByRecipeId() throws Exception {

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(2L);

        Set<IngredientCommand> ingredientCommands = new HashSet<>();
        ingredientCommands.add(ingredientCommand);
        recipeCommand.setIngredients(ingredientCommands);

        Mockito.when(recipeService.getRecipeCommandById(Matchers.anyLong())).thenReturn(recipeCommand);

        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1/ingredients"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("showIngredientsDetails"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("ingredients"));
    }



    @Test
    public void showIngredientByIngredientIDAndRecipeId() throws Exception {

        Mockito.when(ingredientService.findByRecipeIdAndIngredientId(Matchers.anyLong(),Matchers.anyLong())).thenReturn(new IngredientCommand());

        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1/ingredient/2/show"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("showIndividualIngredient"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("ingredient"));

        Mockito.verify(ingredientService,Mockito.times(1)).findByRecipeIdAndIngredientId(Matchers.anyLong(),Matchers.anyLong());
    }

}