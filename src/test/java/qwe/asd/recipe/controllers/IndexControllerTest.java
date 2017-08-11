package qwe.asd.recipe.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.services.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anySet;
import static org.mockito.Matchers.eq;

public class IndexControllerTest {

    @Mock
    private RecipeService recipeService;
    @Mock
    private Model model;

    private IndexController indexController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() throws Exception {
        assertEquals("index",indexController.getIndexPage(model));
        Mockito.verify(recipeService,Mockito.times(1)).getAllRecipes();
        Mockito.verify(model,Mockito.times(1)).addAttribute(eq("recipes"),anySet());
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

}