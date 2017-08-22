package qwe.asd.recipe.converters;

import org.junit.Before;
import org.junit.Test;
import qwe.asd.recipe.commands.CategoryCommand;
import qwe.asd.recipe.domains.Category;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {


    private CategoryCommandToCategory categoryCommandToCategory;


    @Before
    public void setUp() throws Exception {
        categoryCommandToCategory = new CategoryCommandToCategory();
    }


    @Test
    public void testNull() throws Exception {
        //given
        CategoryCommand categoryCommand = null;

        //when
        Category category = categoryCommandToCategory.convert(categoryCommand);

        //then
        assertNull(category);
    }


    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(1L);
        categoryCommand.setDescription("south indian");

        //when
        Category category = categoryCommandToCategory.convert(categoryCommand);

        //then
        assertEquals(Long.valueOf(1L),category.getId());
        assertEquals("south indian",category.getDescription());


    }



}