package qwe.asd.recipe.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.repositories.RecipeRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

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

        List<Recipe> recipeList = new ArrayList<>();

        when(recipeRepo.findAll()).thenReturn(recipeList);

        //line throwing null pointer exception
        Set<Recipe> recipes = recipeService.getAllRecipes();
    }

}