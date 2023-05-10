package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @GetMapping("/donationForm")
    public String add(Model model) {
        model.addAttribute("donation", new Donation());
//        model.asMap().forEach((k, v) -> logger.debug(k + ": " + v));
        return "/form";
    }


    @ModelAttribute("categoryList")
    public List<Category> getCategories() {
        return categoryService.findAll();

    }

    @ModelAttribute("institutionList")
    public List<Institution> getInstitutions() {
        return institutionService.findAll();
    }

}
