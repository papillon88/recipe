package qwe.asd.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import qwe.asd.recipe.domains.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Long> {
}
