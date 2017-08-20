package qwe.asd.recipe.converters;

import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.commands.UnitOfMeasureCommand;
import qwe.asd.recipe.domains.UnitOfMeasure;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand,UnitOfMeasure> {


    @Synchronized
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if(source == null)
            return null;

        final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(source.getId());
        unitOfMeasure.setUom(source.getUom());
        return unitOfMeasure;
    }
}
