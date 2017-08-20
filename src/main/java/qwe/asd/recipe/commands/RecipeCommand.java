package qwe.asd.recipe.commands;

import lombok.Data;
import qwe.asd.recipe.domains.Category;
import qwe.asd.recipe.domains.Ingredient;
import qwe.asd.recipe.domains.Note;
import qwe.asd.recipe.enumerations.Difficulty;

import java.util.HashSet;
import java.util.Set;

@Data
public class RecipeCommand {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;

    
    private NoteCommand noteCommand;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Set<CategoryCommand> categories = new HashSet<>();

}
