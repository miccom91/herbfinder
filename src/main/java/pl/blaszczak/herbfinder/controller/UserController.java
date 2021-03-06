package pl.blaszczak.herbfinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.blaszczak.herbfinder.domain.User;
import pl.blaszczak.herbfinder.dto.UserTO;
import pl.blaszczak.herbfinder.services.UserService;

@Controller
//oznaczamy nią kontrolery, tj. klasy, które będą obsługiwały zapytania wysyłane poprzez przeglądarkę od użytkowników
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUser(Model model) {
        model.addAttribute("lista", userService.getListAllUser());
        return "pages/userlist";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }

    @GetMapping("/registration")
    public String prepareForm(UserTO userTO) {
        return "pages/registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute UserTO userTO) {
        userService.createUser(userTO);
        return "redirect:/login";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "pages/edituser";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Integer id, @ModelAttribute User user) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/user";
    }

    @GetMapping("/show/{id}")
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "pages/user";
    }

    @GetMapping("/showyou/{name}")
    public String showUser(@PathVariable String name, Model model){
        model.addAttribute("user", userService.getUserByName(name));
        return "pages/user";
    }

    @GetMapping("/setactive/{name}")
    public String setActive(@PathVariable String name){
        userService.activeUser(name);
        return "redirect:/user";
    }
}
