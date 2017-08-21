package qwe.asd.recipe.converters;

import org.junit.Before;
import org.junit.Test;
import qwe.asd.recipe.commands.CategoryCommand;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {


    private CategoryCommandToCategory categoryCommandToCategory;


    @Before
    public void setUp() throws Exception {
        categoryCommandToCategory = new CategoryCommandToCategory();
    }

    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
    }

}