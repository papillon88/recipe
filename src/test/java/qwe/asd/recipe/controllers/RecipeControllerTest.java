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
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.services.RecipeService;

import static org.junit.Assert.*;

public class RecipeControllerTest {

    private RecipeController recipeController;

    @Mock
    private Model model;

    @Mock
    private RecipeService recipeService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController();
        recipeController.setRecipeService(recipeService);
    }

    @Test
    public void showById() throws Exception {
        assertEquals("show",recipeController.showById("1",model));
        Mockito.verify(recipeService,Mockito.times(1)).getRecipeById(Matchers.anyLong());
        Mockito.verify(model,Mockito.times(1)).addAttribute(Matchers.eq("recipe"),Matchers.anyObject());
    }

    @Test
    public void recipeControllerMockMVC() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        Mockito.when(recipeService.getRecipeById(Matchers.anyLong())).thenReturn(recipe);

        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/show/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("show"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("recipe"));
    }

}