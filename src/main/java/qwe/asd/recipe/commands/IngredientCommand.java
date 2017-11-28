package qwe.asd.recipe.commands;

import lombok.Data;
import qwe.asd.recipe.domains.UnitOfMeasure;

import java.math.BigDecimal;

@Data
public class IngredientCommand {
    private Long id;
    private String description;
    private BigDecimal amount;
    private Long recipeId;
    private UnitOfMeasureCommand unitOfMeasureCommand;

    public IngredientCommand(Long id) {
        this.id = id;
    }

    public IngredientCommand(UnitOfMeasureCommand unitOfMeasureCommand) {
        this.unitOfMeasureCommand = unitOfMeasureCommand;
    }

    public IngredientCommand() {
    }
}
