package qwe.asd.recipe.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import qwe.asd.recipe.domains.UnitOfMeasure;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepoTest {

    @Autowired
    private UnitOfMeasureRepo unitOfMeasureRepo;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByUomTeaspoon() throws Exception {

        Optional<UnitOfMeasure> uomOptional =
                unitOfMeasureRepo.findByUom("teaspoon");
        assertEquals("teaspoon",uomOptional.get().getUom());
    }

    @Test
    public void findByUomCup() throws Exception {

        Optional<UnitOfMeasure> uomOptional =
                unitOfMeasureRepo.findByUom("cup");
        assertEquals("cup",uomOptional.get().getUom());
    }

}