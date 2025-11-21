package com.example.poketft.controller;

import com.example.poketft.model.entity.Joueur;
import com.example.poketft.service.JoueurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/joueurs")
public class JoueurController {

    private final JoueurService joueurService;

    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    @GetMapping
    public String listJoueurs(@RequestParam(value = "q", required = false) String query, Model model) {
        model.addAttribute("joueurs", joueurService.searchByPseudo(query));
        model.addAttribute("q", query);
        return "joueurs/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("joueur", new Joueur());
        return "joueurs/form";
    }

    @PostMapping
    public String createJoueur(@ModelAttribute Joueur joueur) {
        if (joueur.getElo() == 0) {
            joueur.setElo(1000);
        }
        joueurService.save(joueur);
        return "redirect:/joueurs";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Joueur joueur = joueurService.findById(id);
        if (joueur == null) {
            return "redirect:/joueurs";
        }
        model.addAttribute("joueur", joueur);
        return "joueurs/edit";
    }

    @PutMapping("/{id}")
    public String updateJoueur(@PathVariable Long id, @ModelAttribute Joueur updated) {
        Joueur existing = joueurService.findById(id);
        if (existing == null) {
            return "redirect:/joueurs";
        }
        existing.setPseudo(updated.getPseudo());
        existing.setEmail(updated.getEmail());
        existing.setElo(updated.getElo());
        joueurService.save(existing);
        return "redirect:/joueurs";
    }

    @DeleteMapping("/{id}")
    public String deleteJoueur(@PathVariable Long id) {
        joueurService.deleteById(id);
        return "redirect:/joueurs";
    }
}
