package com.example.poketft.controller;

import com.example.poketft.model.entity.CreatureEspece;
import com.example.poketft.service.CreatureEspeceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/especes")
public class CreatureEspeceController {

    private final CreatureEspeceService creatureEspeceService;

    public CreatureEspeceController(CreatureEspeceService creatureEspeceService) {
        this.creatureEspeceService = creatureEspeceService;
    }

    @GetMapping
    public String listEspeces(Model model) {
        model.addAttribute("especes", creatureEspeceService.findAll());
        return "especes/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("espece", new CreatureEspece());
        return "especes/form";
    }

    @PostMapping
    public String createEspece(@ModelAttribute CreatureEspece espece) {
        creatureEspeceService.save(espece);
        return "redirect:/especes";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        CreatureEspece espece = creatureEspeceService.findById(id);
        if (espece == null) {
            return "redirect:/especes";
        }
        model.addAttribute("espece", espece);
        return "especes/edit";
    }

    @PutMapping("/{id}")
    public String updateEspece(@PathVariable Long id, @ModelAttribute CreatureEspece updated) {
        CreatureEspece existing = creatureEspeceService.findById(id);
        if (existing == null) {
            return "redirect:/especes";
        }
        existing.setNom(updated.getNom());
        existing.setBasePv(updated.getBasePv());
        existing.setBaseAttaque(updated.getBaseAttaque());
        existing.setBaseDefense(updated.getBaseDefense());
        existing.setBaseVitesse(updated.getBaseVitesse());
        existing.setRarete(updated.getRarete());
        existing.setSpritePath(updated.getSpritePath());
        creatureEspeceService.save(existing);
        return "redirect:/especes";
    }

    @DeleteMapping("/{id}")
    public String deleteEspece(@PathVariable Long id) {
        creatureEspeceService.deleteById(id);
        return "redirect:/especes";
    }
}
