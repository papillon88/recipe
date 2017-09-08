package qwe.asd.recipe.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import qwe.asd.recipe.commands.RecipeCommand;
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.services.RecipeService;

import static org.junit.Assert.*;

public class RecipeControllerTest {

    private RecipeController recipeController;

    @Mock
    private Model model;

    @Mock
    private RecipeService recipeService;

    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController();
        recipeController.setRecipeService(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Test
    public void testShowRecipeById() throws Exception {
        assertEquals("showRecipeDetail",recipeController.showRecipeById("1",model));
        Mockito.verify(recipeService,Mockito.times(1)).getRecipeCommandById(Matchers.anyLong());
        Mockito.verify(model,Mockito.times(1)).addAttribute(Matchers.eq("recipe"),Matchers.anyObject());

        RecipeCommand recipe = new RecipeCommand();
        recipe.setId(1L);
        Mockito.when(recipeService.getRecipeCommandById(Matchers.anyLong())).thenReturn(recipe);

        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("showRecipeDetail"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("recipe"));
    }

    @Test
    public void testShowRecipeFormForCreation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/new"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("recipeform"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("recipe"));

    }

    @Test
    public void testPostSubmitRecipeForm() throws Exception {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        Mockito.when(recipeService.saveRecipeCommand(Matchers.any(RecipeCommand.class))).thenReturn(recipeCommand);

        mockMvc.perform(MockMvcRequestBuilders.post("/recipe/create")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id","")
                .param("description","some string"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/"));
    }

    @Test
    public void testUpdateRecipeById() throws Exception {
        Mockito.when(recipeService.getRecipeCommandById(Matchers.anyLong())).thenReturn(new RecipeCommand());
        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1/update"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("recipeform"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("recipe"));
        Mockito.verify(recipeService,Mockito.times(1)).getRecipeCommandById(Matchers.anyLong());

        assertEquals("recipeform",recipeController.updateRecipeById("1",model));
        Mockito.verify(model,Mockito.times(1)).addAttribute(Matchers.eq("recipe"),Matchers.anyObject());

    }

    @Test
    public void testDeleteRecipeById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1/delete"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/"));
        Mockito.verify(recipeService,Mockito.times(1)).deleteRecipeById(Matchers.anyLong());

    }

}