package qwe.asd.recipe.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.repositories.RecipeRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepo recipeRepo;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepo);
    }

    @Test
    public void getAllRecipes() throws Exception {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());
        Mockito.when(recipeRepo.findAll()).thenReturn(recipeSet);
        Set<Recipe> recipes = recipeService.getAllRecipes();

        assertEquals(recipes.size(),1);
        Mockito.verify(recipeRepo,Mockito.times(1)).findAll();


    }

}