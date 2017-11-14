package qwe.asd.recipe.domains;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;

    /*******************
     ******************
     Constructors
     ******************
     *******************/
    public Ingredient(){}

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Ingredient(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }


}
