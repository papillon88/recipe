package qwe.asd.recipe.converters;

import org.junit.Before;
import org.junit.Test;
import qwe.asd.recipe.commands.CategoryCommand;
import qwe.asd.recipe.domains.Category;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    private CategoryToCategoryCommand categoryToCategoryCommand;


    @Before
    public void setUp() throws Exception {
        categoryToCategoryCommand = new CategoryToCategoryCommand();
    }

    @Test
    public void testNull() throws Exception {
        assertNull(categoryToCategoryCommand.convert(null));
    }

    @Test
    public void convert() throws Exception {
        Category category = new Category();
        category.setId(1L);
        category.setDescription("south indian");

        CategoryCommand categoryCommand = categoryToCategoryCommand.convert(category);
        assertEquals(Long.valueOf(1L),categoryCommand.getId());
        assertEquals("south indian",categoryCommand.getDescription());

    }

}