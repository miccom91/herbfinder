package pl.blaszczak.herbfinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.blaszczak.herbfinder.repository.HerbRepository;
import pl.blaszczak.herbfinder.services.HerbService;

@Controller
@RequestMapping("/herb")
@AllArgsConstructor

public class HerbController {
    private  final HerbService herbService;

    @GetMapping
    public String getAllHerbs(Model model){
        model.addAttribute("herbList", herbService.getListAllHerbs());
        return "pages/herbList";
    }

}
