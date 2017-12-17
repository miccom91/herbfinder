package pl.blaszczak.herbfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("nameapp", "HerbFinder");
        model.addAttribute("deskriptionapp", "Aplikacja mająca na celu ułatwienie lokalizowania ziół polskich");
        return "pages/index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "pages/login";
    }

    @GetMapping("/errors")
    public String error() {
        return "pages/error";
    }
}
