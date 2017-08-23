package qwe.asd.recipe.commands;

import lombok.Data;

@Data
public class CategoryCommand {
    private Long id;
    private String description;

    public CategoryCommand(Long id) {
        this.id = id;
    }

    public CategoryCommand() {
    }
}
