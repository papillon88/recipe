package qwe.asd.recipe.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import qwe.asd.recipe.domains.*;
import qwe.asd.recipe.enumerations.Difficulty;
import qwe.asd.recipe.repositories.CategoryRepo;
import qwe.asd.recipe.repositories.RecipeRepo;
import qwe.asd.recipe.repositories.UnitOfMeasureRepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private RecipeRepo recipeRepo;
    @Autowired
    private UnitOfMeasureRepo unitOfMeasureRepo;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepo.save(getRecipes());
    }

    private List<Recipe> getRecipes(){

        List<Recipe> recipes = new ArrayList<>();

        //get Optional UOMs
        Optional<UnitOfMeasure> teaSpoonOptional = unitOfMeasureRepo.findByUom("teaspoon");
        if(!teaSpoonOptional.isPresent()){
            throw new RuntimeException("expected UOM not found");
        }

        Optional<UnitOfMeasure> tableSpoonOptional = unitOfMeasureRepo.findByUom("tablespoon");
        if(!tableSpoonOptional.isPresent()){
            throw new RuntimeException("expected UOM not found");
        }

        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepo.findByUom("cup");
        if(!cupOptional.isPresent()){
            throw new RuntimeException("expected UOM not found");
        }

        Optional<UnitOfMeasure> pinchOptional = unitOfMeasureRepo.findByUom("pinch");
        if(!pinchOptional.isPresent()){
            throw new RuntimeException("expected UOM not found");
        }

        Optional<UnitOfMeasure> ounceOptional = unitOfMeasureRepo.findByUom("ounce");
        if(!ounceOptional.isPresent()){
            throw new RuntimeException("expected UOM not found");
        }

        Optional<UnitOfMeasure> pintOptional = unitOfMeasureRepo.findByUom("pint");
        if(!ounceOptional.isPresent()){
            throw new RuntimeException("expected UOM not found");
        }

        Optional<UnitOfMeasure> numberOptional = unitOfMeasureRepo.findByUom("number");
        if(!ounceOptional.isPresent()){
            throw new RuntimeException("expected UOM not found");
        }


        //get Actual UOMs
        UnitOfMeasure teaSpoonUom = teaSpoonOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonOptional.get();
        UnitOfMeasure cupUom = cupOptional.get();
        UnitOfMeasure pinchUom = pinchOptional.get();
        UnitOfMeasure ounceUom = ounceOptional.get();
        UnitOfMeasure pintUom = ounceOptional.get();
        UnitOfMeasure numberUom = ounceOptional.get();

        //get Optional Categories
        Optional<Category> americanOptional = categoryRepo.findByDescription("american");
        if(!americanOptional.isPresent()){
            throw new RuntimeException("expected Category not found");
        }

        Optional<Category> mexicanOptional = categoryRepo.findByDescription("mexican");
        if(!mexicanOptional.isPresent()){
            throw new RuntimeException("expected Category not found");
        }

        Optional<Category> indianOptional = categoryRepo.findByDescription("indian");
        if(!indianOptional.isPresent()){
            throw new RuntimeException("expected Category not found");
        }

        Optional<Category> italianOptional = categoryRepo.findByDescription("italian");
        if(!italianOptional.isPresent()){
            throw new RuntimeException("expected Category not found");
        }

        //get Actual Categories
        Category americanCategory = americanOptional.get();
        Category mexicanCategory = mexicanOptional.get();
        Category indianCategory = indianOptional.get();
        Category italianCategory = italianOptional.get();


        //spicy grilled chicken taco
        Recipe spcyGrldChknTaco = new Recipe();
        spcyGrldChknTaco.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. " +
                "Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        spcyGrldChknTaco.setPrepTime(20);
        spcyGrldChknTaco.setCookTime(15);
        spcyGrldChknTaco.setServings(5);
        spcyGrldChknTaco.setSource("www.simplyrecipes.com");
        spcyGrldChknTaco.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        String spcyGrldChknTacoDirections = "Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, " +
                "cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose " +
                "paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer " +
                "inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. " +
                "As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for " +
                "a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. " +
                "Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned " +
                "sour cream. Serve with lime wedges.\n";
        spcyGrldChknTaco.setDirections(spcyGrldChknTacoDirections);
        String spcyGrldChknTacoNote = "Any and every kind of leftover can go inside a warm tortilla, " +
                "usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night " +
                "snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and " +
                "sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble " +
                "the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "The ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep " +
                "reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find " +
                "ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: " +
                "avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. " +
                "I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some " +
                "in the fridge and I think it adds a nice green crunch to the tacos.\n" ;
        Note note = new Note(spcyGrldChknTacoNote);
        spcyGrldChknTaco.setNote(note);
        spcyGrldChknTaco.setDifficulty(Difficulty.MEDIUM);
        spcyGrldChknTaco.getCategories().add(mexicanCategory);
        spcyGrldChknTaco.addIngredient(new Ingredient("ancho chili powder",new BigDecimal(2),tableSpoonUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("dried oregano",new BigDecimal(1),teaSpoonUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("sugar",new BigDecimal(1),teaSpoonUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("dried cumin",new BigDecimal(1),teaSpoonUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("salt",new BigDecimal(1/2),teaSpoonUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("finely chopped garlic clove",new BigDecimal(1),numberUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("finely grated orange zest",new BigDecimal(1),tableSpoonUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("fresh squeezed orange juice",new BigDecimal(3),tableSpoonUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("olive oil",new BigDecimal(2),tableSpoonUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("chicken thighs",new BigDecimal(5),numberUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("corn tortillas",new BigDecimal(8),numberUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("baby arugula",new BigDecimal(3),cupUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("sliced ripe avocados",new BigDecimal(2),numberUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("thinly sliced radishes",new BigDecimal(4),numberUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("halved cherry tomatoes",new BigDecimal(0.5),pintUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("thinly sliced red onions",new BigDecimal(0.25),numberUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("roughly chopped cilantro",new BigDecimal(1),pintUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("sour cream",new BigDecimal(0.5),cupUom));
        spcyGrldChknTaco.addIngredient(new Ingredient("wedges cut lime",new BigDecimal(1),numberUom));


        recipes.add(spcyGrldChknTaco);

        return recipes;
    }
}
