package TestRestProj.RestNew.controllers;

import TestRestProj.RestNew.services.AnimalService;
import TestRestProj.RestNew.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AnimalService animalService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/home")
    public String openHome(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        return "home";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/details/{id}")
    public  String openDetails(@PathVariable("id") Long id , Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("animal" , animalService.getAnimal(id));
        return "details";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/login")
    public String openLogin(){
       return "login";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value ="/profile")
    public String openProfile(){
        return "profile";
    }

}
