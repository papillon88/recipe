package qwe.asd.recipe.converters;

import org.junit.Before;
import org.junit.Test;
import qwe.asd.recipe.commands.NoteCommand;
import qwe.asd.recipe.domains.Note;

import static org.junit.Assert.*;

public class NoteToNoteCommandTest {


    private NoteToNoteCommand noteToNoteCommand;


    @Before
    public void setUp() throws Exception {
        noteToNoteCommand = new NoteToNoteCommand();
    }

    @Test
    public void testNull() throws  Exception {
        assertNull(noteToNoteCommand.convert(null));
    }

    @Test
    public void convert() throws Exception {
        Note note = new Note();
        note.setId(1L);
        note.setRecipeNotes("recipe notes");
        NoteCommand noteCommand = noteToNoteCommand.convert(note);

        assertNotNull(noteCommand);
        assertEquals("recipe notes",noteCommand.getRecipeNotes());

    }

}