package qwe.asd.recipe.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import qwe.asd.recipe.commands.RecipeCommand;
import qwe.asd.recipe.converters.RecipeToRecipeCommand;
import qwe.asd.recipe.domains.Recipe;
import qwe.asd.recipe.repositories.RecipeRepo;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceImplIT {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private RecipeRepo recipeRepo;
    @Autowired
    private RecipeToRecipeCommand recipeToRecipeCommand;


    @Test
    @Transactional
    public void testDescSave() throws Exception {

        //behaviour driven testing

        //given
        Iterable<Recipe> recipes = recipeRepo.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(testRecipe);

        //when
        recipeCommand.setDescription("IT desc");
        RecipeCommand receivedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);

        //then
        assertNotNull(receivedRecipeCommand);
        assertEquals("IT desc",receivedRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(),receivedRecipeCommand.getId());
        assertEquals(testRecipe.getDirections(),receivedRecipeCommand.getDirections());
        assertEquals(testRecipe.getIngredients().size(),receivedRecipeCommand.getIngredients().size());

    }

}