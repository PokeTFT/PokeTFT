package com.example.poketft.controller;

import com.example.poketft.model.entity.Partie;
import com.example.poketft.service.PartieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/parties")
public class PartieController {

    private final PartieService partieService;

    public PartieController(PartieService partieService) {
        this.partieService = partieService;
    }

    @GetMapping("/{id}")
    public String detailPartie(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Partie partie = partieService.findById(id);
        if (partie == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Partie introuvable");
            return "redirect:/joueurs";
        }
        model.addAttribute("partie", partie);
        return "parties/detail";
    }

    @GetMapping("/start")
    public String demarrerPartie(@RequestParam("joueurId") Long joueurId, RedirectAttributes redirectAttributes) {
        Partie partie = partieService.demarrerNouvellePartiePourJoueur(joueurId);
        if (partie == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Joueur introuvable");
            return "redirect:/joueurs";
        }
        return "redirect:/parties/" + partie.getId();
    }
}
