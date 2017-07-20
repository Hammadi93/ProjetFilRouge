package fr.norsys.filrouge.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.norsys.filrouge.entities.Competition;
import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.service.CompetitionService;

@Controller
@RequestMapping("/competitions")
public class CompetitionController {
	@Autowired
	CompetitionService competitionService;

	@RequestMapping(value = "")
	public String listCompetition(Model model, HttpSession session) {
		model.addAttribute("page", "competitions");
		List<Competition> listCompetition = this.competitionService.getAllCompetitions();
		Personne personneSession = (Personne) session.getAttribute("personne");
		model.addAttribute("personneSession", personneSession);
		model.addAttribute("listCompetition", listCompetition);

		return "competitions";
	}
}
