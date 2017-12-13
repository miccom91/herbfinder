package pl.blaszczak.herbfinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.blaszczak.herbfinder.domain.Localization;
import pl.blaszczak.herbfinder.services.LocalizationService;

@Controller
@RequestMapping("/localization")
@AllArgsConstructor
public class LocalizationController {

    private  final LocalizationService localizationService;

    @GetMapping
    public String getAllLocalizations(Model model){
        model.addAttribute("localizationList", localizationService.getListAllLocalization());
        return "pages/localizationList";
    }

    @GetMapping("/delete/{id}")
    public String deleteLocalization(@PathVariable int id) {
        localizationService.deleteLocalization(id);
        return "redirect:/localization";
    }

    @GetMapping("/create")
    public String prepareForm(Localization localization){
        return "pages/addlocalization";
    }

    @PostMapping("/create")
    public String addLocalization(@ModelAttribute Localization localization){
        localizationService.createLocalization(localization);
        return "redirect:/localization";
    }

    @GetMapping("/edit/{id}")
    public String editLocalization(@PathVariable Integer id, Model model) {
        model.addAttribute("localization", localizationService.getLocalizationById(id));
        return "pages/editlocalization";
    }

    @PostMapping("/edit/{id}")
    public String editLocalization(@PathVariable Integer id, @ModelAttribute Localization localization){
        localization.setId(id);
        localizationService.updateLocalization(localization);
        return "redirect:/localization";
    }
}
