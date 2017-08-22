package qwe.asd.recipe.converters;

import org.junit.Before;
import org.junit.Test;
import qwe.asd.recipe.commands.NoteCommand;
import qwe.asd.recipe.domains.Note;

import static org.junit.Assert.*;

public class NoteCommandToNoteTest {

    private NoteCommandToNote noteCommandToNote;


    @Before
    public void setUp() throws Exception {
        noteCommandToNote = new NoteCommandToNote();
    }

    @Test
    public void testNull() throws Exception {
        assertNull(noteCommandToNote.convert(null));
    }

    @Test
    public void convert() throws Exception {
        NoteCommand noteCommand = new NoteCommand();
        noteCommand.setId(1L);
        noteCommand.setRecipeNotes("test recipe notes");

        Note note = noteCommandToNote.convert(noteCommand);

        assertNotNull(note);
        assertEquals(Long.valueOf(1L),note.getId());
        assertEquals("test recipe notes",note.getRecipeNotes());
    }

}