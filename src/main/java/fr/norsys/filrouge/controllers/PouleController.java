package fr.norsys.filrouge.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Poule;
import fr.norsys.filrouge.service.PouleService;

@Controller
@RequestMapping("/poulles")
public class PouleController {
	@Autowired
	PouleService poulleService;

	@RequestMapping(value = "/{idCompetition}")
	public String index(Model model, @PathVariable int idCompetition, HttpSession session) {
		List<Poule> listPoules = this.poulleService.getAllPoullesByCompetition(idCompetition);
		Personne personneSession = (Personne) session.getAttribute("personne");
		model.addAttribute("personneSession", personneSession);

		model.addAttribute("listPoulles", listPoules);
		model.addAttribute("page", "poules");

		return "poules";
	}
}
