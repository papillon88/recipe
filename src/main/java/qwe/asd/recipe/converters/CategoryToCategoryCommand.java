package qwe.asd.recipe.converters;

import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.commands.CategoryCommand;
import qwe.asd.recipe.domains.Category;

@Component
public class CategoryToCategoryCommand implements Converter<Category,CategoryCommand> {

    @Synchronized
    @Override
    public CategoryCommand convert(Category source) {
        if(source == null)
            return  null;

        final CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());
        return categoryCommand;
    }
}
