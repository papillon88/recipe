package qwe.asd.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import qwe.asd.recipe.domains.UnitOfMeasure;

import java.util.Optional;

@Repository
public interface UnitOfMeasureRepo extends CrudRepository<UnitOfMeasure,Long> {

    public Optional<UnitOfMeasure> findByUom(String description);


}
