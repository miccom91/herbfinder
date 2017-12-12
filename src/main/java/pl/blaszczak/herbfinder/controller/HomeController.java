package pl.blaszczak.herbfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHome(){
        return "pages/index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "pages/login";
    }
}
