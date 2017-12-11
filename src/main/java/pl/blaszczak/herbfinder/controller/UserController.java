package pl.blaszczak.herbfinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.blaszczak.herbfinder.services.UserService;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getAllUser(Model model){
        model.addAttribute("lista",userService.getListAllUser());
        return "pages/userlist";
    }
}
