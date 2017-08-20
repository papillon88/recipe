package qwe.asd.recipe.converters;


import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.commands.NoteCommand;
import qwe.asd.recipe.domains.Note;

@Component
public class NoteCommandToNote implements Converter<NoteCommand,Note> {

    @Synchronized
    @Nullable
    @Override
    public Note convert(NoteCommand source) {
        if(source == null)
            return null;

        final Note note = new Note();
        note.setId(source.getId());
        note.setRecipeNotes(source.getRecipeNotes());
        return note;
    }
}
