package qwe.asd.recipe.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import qwe.asd.recipe.commands.IngredientCommand;
import qwe.asd.recipe.converters.RecipeToRecipeCommand;
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.repositories.RecipeRepo;

import javax.transaction.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientServiceImpl_Integration_Test {

    @Autowired
    private RecipeRepo recipeRepo;
    @Autowired
    private RecipeToRecipeCommand recipeToRecipeCommand;
    @Autowired
    private IngredientService ingredientService;

    @Test
    @Transactional
    @DirtiesContext
    public void findByRecipeIdAndIngredientId() throws Exception {
        //given
        Set<Recipe> recipes = new HashSet<>();
        recipeRepo.findAll().forEach(recipe -> recipes.add(recipe));
        IngredientCommand ingredientCommFromRepo = recipeToRecipeCommand.convert(recipes.stream()
                .filter(recipe -> recipe.getId() == 1L)
                .findFirst()
                .get())
                .getIngredients().stream()
                .filter(ingredient -> ingredient.getId() == 1L)
                .findFirst()
                .get();
        IngredientCommand ingredientCommFromService = ingredientService.findByRecipeIdAndIngredientId(1L, 1L);

        assertEquals(ingredientCommFromRepo.getId(),ingredientCommFromService.getId());
        assertEquals(ingredientCommFromRepo.getUnitOfMeasureCommand().getUom(),ingredientCommFromService.getUnitOfMeasureCommand().getUom());
        assertEquals(ingredientCommFromRepo.getAmount(),ingredientCommFromService.getAmount());
        assertEquals(ingredientCommFromRepo.getDescription(),ingredientCommFromService.getDescription());
    }

}