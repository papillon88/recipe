package qwe.asd.recipe.converters;

import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.commands.NoteCommand;
import qwe.asd.recipe.domains.Note;


@Component
public class NoteToNoteCommand implements Converter<Note,NoteCommand> {

    @Synchronized
    @Nullable
    @Override
    public NoteCommand convert(Note source) {
        if(source == null)
            return null;
        final NoteCommand noteCommand = new NoteCommand();
        noteCommand.setId(source.getId());
        noteCommand.setRecipeNotes(source.getRecipeNotes());
        return noteCommand;
    }
}
