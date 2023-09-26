package pl.coderslab.charity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/registration")
    public String showForm(Model model) {
        model.addAttribute("donation", new Donation());
//        model.asMap().forEach((k, v) -> logger.debug(k + ": " + v));
        return "register/form";
    }

    @PostMapping("/registration")
    public String saveUser(@Valid User user, BindingResult result) {
        //TODO zamiast usera dać DTO (bo dwa pola password)

        //TODO: validator przyjmujący bindingresult
        if (result.hasErrors()) {
            return "register/form";
        }
        userService.save(user);


        return "redirect:/";
    }
}
