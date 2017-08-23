package qwe.asd.recipe.commands;

import lombok.Data;

@Data
public class NoteCommand {
    private Long id;
    private String recipeNotes;

    public NoteCommand(Long id) {
        this.id = id;
    }

    public NoteCommand() {
    }
}
