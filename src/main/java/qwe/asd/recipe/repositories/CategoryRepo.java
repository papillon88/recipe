package qwe.asd.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import qwe.asd.recipe.domains.Category;

import java.util.Optional;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Long> {

    public Optional<Category> findByDescription(String description);


}
