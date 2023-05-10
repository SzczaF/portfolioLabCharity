package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
@RequiredArgsConstructor

public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    @RequestMapping("/")
    public String homeAction(Model model) {
        //TODO jak ograniczyć liczbe rekordów -- Pageable
        Pageable limit = PageRequest.of(0, 6, Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("allInstitutionList", institutionRepository.findAll(limit).get().toList());

        model.addAttribute("bagCount", donationRepository.getSumOfAllBags().orElse(0L));
        model.addAttribute("donationCount", donationRepository.count());
        return "index";
    }
}
