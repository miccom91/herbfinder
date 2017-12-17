package pl.blaszczak.herbfinder.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.blaszczak.herbfinder.domain.Attribute;
import pl.blaszczak.herbfinder.services.AttributeService;

@Controller
@RequestMapping("/attribute")
@AllArgsConstructor
public class AttributeController {

    private final AttributeService attributeService;

    @GetMapping
    public String getAllAttributes(Model model) {
        model.addAttribute("attributeList", attributeService.getListAllAttributes());
        return "pages/attributelist";
    }

    @GetMapping("/delete/{id}")
    public String deleteAttribute(@PathVariable int id) {
        attributeService.deleteAttribute(id);
        return "redirect:/attribute";
    }

    @GetMapping("/create")
    public String prepareForm(Attribute attribute) {
        return "pages/addattribute";
    }

    @PostMapping("/create")
    public String addAttribute(@ModelAttribute Attribute attribute) {
        attributeService.createAttribute(attribute);
        return "redirect:/attribute";
    }

    @GetMapping("/edit/{id}")
    public String editAtribute(@PathVariable int id, Model model) {
        model.addAttribute("attribute", attributeService.getAttributeById(id));
        return "pages/editattribute";
    }

    @PostMapping("/edit/{id}")
    public String editAtribute(@PathVariable Integer id, @ModelAttribute Attribute attribute) {
        attribute.setId(id);
        attributeService.updateAttribute(attribute);
        return "redirect:/attribute";
    }
}
