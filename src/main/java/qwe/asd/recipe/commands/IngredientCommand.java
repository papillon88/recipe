package qwe.asd.recipe.commands;

import lombok.Data;
import qwe.asd.recipe.domains.UnitOfMeasure;

import java.math.BigDecimal;

@Data
public class IngredientCommand {
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure unitOfMeasure;
}
