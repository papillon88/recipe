package qwe.asd.recipe.domains;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String recipeNotes;
    @OneToOne(mappedBy = "note")
    private Recipe recipe;

    /*******************
     ******************
     Constructors
     ******************
     *******************/

    public Note(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

    public Note(String recipeNotes, Recipe recipe) {
        this.recipeNotes = recipeNotes;
        this.recipe = recipe;
    }

    public Note(){}



}
