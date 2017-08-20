package qwe.asd.recipe.converters;


import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.commands.CategoryCommand;
import qwe.asd.recipe.domains.Category;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand,Category>{

    @Synchronized
    @Override
    public Category convert(CategoryCommand source) {
        if(source == null)
            return null;

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
