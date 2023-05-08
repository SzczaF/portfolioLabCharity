package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
@RequiredArgsConstructor

public class HomeController {

    private final InstitutionRepository institutionRepository;
    @RequestMapping("/")
    public String homeAction(Model model) {
        //TODO Jak tu sięużywa Sorted.by...
        model.addAttribute("allInstitutionList", institutionRepository.findAll());
        return "index";

    }
}
