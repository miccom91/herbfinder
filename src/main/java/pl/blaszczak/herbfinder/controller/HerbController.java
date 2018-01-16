package pl.blaszczak.herbfinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.blaszczak.herbfinder.domain.Attribute;
import pl.blaszczak.herbfinder.domain.Herb;
import pl.blaszczak.herbfinder.dto.HerbTO;
import pl.blaszczak.herbfinder.services.AttributeService;
import pl.blaszczak.herbfinder.services.HerbService;

@Controller
@RequestMapping("/herb")
@AllArgsConstructor
public class HerbController {

    private final HerbService herbService;

    private final AttributeService attributeService;

    @GetMapping
    public String getAllHerbs(Model model) {
        model.addAttribute("herbList", herbService.getListAllHerbs());
        return "pages/herbs";
    }

    @GetMapping("/delete/{id}")
    public String deleteHerb(@PathVariable int id) {
        herbService.deleteHerb(id);
        return "redirect:/herb";
    }

    @GetMapping("/create")
    public String prepareForm(HerbTO herbTO, Model model) {
        model.addAttribute("attributeList", attributeService.getListAllAttributes());
        return "pages/addherb";
    }

    @PostMapping("/create")
    public String addHerb(@ModelAttribute HerbTO herbTO) {
        herbService.createHerb(herbTO);
        return "redirect:/herb";
    }

    @GetMapping("/edit/{id}")
    public String editHerb(@PathVariable Integer id, Model model) {
        model.addAttribute("herb", herbService.getHerbById(id));
        return "pages/editherb";
    }

    @PostMapping("/edit/{id}")
    public String editHerb(@PathVariable Integer id, @ModelAttribute Herb herb) {
        herb.setId(id);
        herbService.updateHerb(herb);
        return "redirect:/herb";
    }

    @GetMapping("/show/{id}")
    public String showHerb(@PathVariable Integer id, Model model) {
        model.addAttribute("herb", herbService.getHerbById(id));
        return "pages/herb";
    }
}
