package fr.norsys.filrouge.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;
import fr.norsys.filrouge.entities.Rencontre;
import fr.norsys.filrouge.service.PersonneService;
import fr.norsys.filrouge.service.PouleService;
import fr.norsys.filrouge.service.PronosticService;
import fr.norsys.filrouge.service.RencontreService;

@Controller
@RequestMapping("/pronostic")
public class PronosticsController {

	@Autowired
	PronosticService pronosticService;

	@Autowired
	RencontreService rencontreService;

	@Autowired
	PouleService polleService;

	@Autowired
	PersonneService personneService;

	List<Rencontre> listRencontres;

	@RequestMapping(value = "/{idPolle}")
	public String listCompetition(Model model, HttpSession session, @PathVariable("idPolle") int idPolle) {

		Personne personneSession = (Personne) session.getAttribute("personne");
		model.addAttribute("personneSession", personneSession);
		this.listRencontres = this.rencontreService.getAllRencontresByPolle(this.polleService.getPoulle(idPolle).get());
		model.addAttribute("listRencontre", this.listRencontres);
		model.addAttribute("count", 0);
		return "pronostic";
	}

	@RequestMapping(value = "/{idPolle}", method = RequestMethod.POST)
	public String savePronostic(Model model, HttpSession session, @PathVariable("idPolle") int idPolle,
			HttpServletRequest request) {
		Personne personneSession = (Personne) session.getAttribute("personne");
		model.addAttribute("personneSession", personneSession);
		Rencontre rencontre = new Rencontre();
		rencontre = this.rencontreService.getRencontre(Integer.valueOf(request.getParameter("rencontre")));

		Pronostic pronostic = new Pronostic(0, Integer.valueOf(request.getParameter("butEquipe1")),
				Integer.valueOf(request.getParameter("butEquipe2")), 0, rencontre, personneSession);
		this.listRencontres = this.rencontreService.getAllRencontresByPolle(this.polleService.getPoulle(idPolle).get());

		if (this.pronosticService.isPronosticsExist(personneSession, rencontre)) {
			model.addAttribute("msg", "Prostic déja exist");
			return "404";
		} else if (this.pronosticService.dejaJouer(rencontre)) {
			model.addAttribute("msg", "Match déja joué");
			return "404";
		} else {
			this.pronosticService.createPronostic(pronostic);
		}
		this.listCompetition(model, session, idPolle);

		return "successfull";

	}

	@RequestMapping(value = "/mesPronostic")
	public String listPronosticPersonne(Model model, HttpSession session) {
		model.addAttribute("page", "mesPronostic");
		Personne personneSession = (Personne) session.getAttribute("personne");
		model.addAttribute("personneSession", personneSession);
		List<Pronostic> pronosticsPersonne = this.pronosticService.getPronosticsByPersonne(personneSession);
		model.addAttribute("pronosticsPersonne", pronosticsPersonne);
		return "mesPronostic";
	}

	@RequestMapping(value = "/delete")
	public String deletePronostic(Model model, @RequestParam("idPronostic") int idPronostic, HttpSession session) {
		this.pronosticService.deletePronostic(idPronostic);
		return this.listPronosticPersonne(model, session);
	}
}
