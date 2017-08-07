package qwe.asd.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import qwe.asd.recipe.domains.Category;
import qwe.asd.recipe.domains.UnitOfMeasure;
import qwe.asd.recipe.repositories.CategoryRepo;
import qwe.asd.recipe.repositories.UnitOfMeasureRepo;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private UnitOfMeasureRepo unitOfMeasureRepo;

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){
        System.out.println("recipe....");
        Optional<Category> category = categoryRepo.findByDescription("american");
        Optional<UnitOfMeasure> uom = unitOfMeasureRepo.findByUom("teaspoon");
        System.out.println("Category is " + category.get().getId());
        System.out.println("Unit of measure is " + uom.get().getId());
        return "index";
    }
}
