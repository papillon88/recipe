package qwe.asd.recipe.commands;


import lombok.Data;

@Data
public class UnitOfMeasureCommand {
    private Long id;
    private String uom;

    public UnitOfMeasureCommand(String uom) {
        this.uom = uom;
    }

    public UnitOfMeasureCommand() {
    }
}
