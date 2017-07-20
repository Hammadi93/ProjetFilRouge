
package fr.norsys.filrouge.controllers;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.norsys.filrouge.entities.Competition;
import fr.norsys.filrouge.entities.Equipe;
import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Poule;
import fr.norsys.filrouge.entities.Pronostic;
import fr.norsys.filrouge.entities.Rencontre;
import fr.norsys.filrouge.service.CompetitionService;
import fr.norsys.filrouge.service.EquipeService;
import fr.norsys.filrouge.service.PersonneService;
import fr.norsys.filrouge.service.PouleService;
import fr.norsys.filrouge.service.PronosticService;
import fr.norsys.filrouge.service.RencontreService;

@Controller
@RequestMapping("/rencontres")
public class RencontreController {
	@Autowired
	RencontreService rencontreService;
	@Autowired
	PouleService poulleService;
	@Autowired
	EquipeService equipeService;
	@Autowired
	PronosticService pronosticService;
	@Autowired
	CompetitionService competitionService;
	@Autowired
	PersonneService personneService;
	final static Logger logger = Logger.getLogger(RencontreController.class);

	@RequestMapping(value = "")
	public String listRencontres(Model model, HttpSession session) {
		model.addAttribute("page", "rencontres");
		Personne personneSession = (Personne) session.getAttribute("personne");
		model.addAttribute("personneSession", personneSession);
		List<Rencontre> listRencontres = this.rencontreService.getAllRencontres();
		model.addAttribute("listRencontres", listRencontres);

		return "rencontres";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String showForm(Model model, Rencontre rencontre, HttpSession session) {
		Personne personneSession = (Personne) session.getAttribute("personne");
		model.addAttribute("personneSession", personneSession);
		model.addAttribute("page", "rencontres");
		List<Poule> listPoulles = this.poulleService.getAllPoulles();
		model.addAttribute("listPoulles", listPoulles);
		List<Equipe> listEquipes = this.equipeService.getAllEquipes();
		model.addAttribute("listEquipes", listEquipes);
		List<Competition> listCompetitions = this.competitionService.getAllCompetitions();
		model.addAttribute("listCompetitions", listCompetitions);
		return "ajouterRencontre";
	}

	@RequestMapping(value = "/doSave", method = RequestMethod.POST)
	public String saveRencontre(Model model, HttpSession session, HttpServletRequest req) {
		Date dateDebut = new Date();
		Date dateFin = new Date();
		Personne personneSession = (Personne) session.getAttribute("personne");
		model.addAttribute("personneSession", personneSession);
		try {
			dateDebut = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(req.getParameter("dateDebut"));
		} catch (ParseException e) {
			logger.error("saveRencontre ParseException Date " + e.getMessage());
		}
		Competition competition = new Competition();
		competition = this.competitionService.getCompetition(Integer.parseInt(req.getParameter("competition"))).get();
		Poule poulle = new Poule();
		poulle = this.poulleService.getPoulle(Integer.parseInt(req.getParameter("poulle"))).get();
		Equipe equipe1 = new Equipe();
		Equipe equipe2 = new Equipe();
		if (req.getParameter("equipe1").equals(req.getParameter("equipe2"))) {
			model.addAttribute("page", "/rencontres");
			model.addAttribute("msg", "Vous avez choisi le même equipe pour les deux equipes!!");
			return "404";
		}
		equipe1 = this.equipeService.getEquipe(Integer.parseInt(req.getParameter("equipe1"))).get();
		equipe2 = this.equipeService.getEquipe(Integer.parseInt(req.getParameter("equipe2"))).get();
		Rencontre rencontre = new Rencontre(0, new Timestamp(dateDebut.getTime()), new Timestamp(dateFin.getTime()), 0,
				0, 0, equipe1, equipe2, poulle, competition);

		int status = this.rencontreService.createRencontre(rencontre);
		if (status > 0) {
			model.addAttribute("msg", "Rencontre bien ajouté");
			model.addAttribute("page", "rencontres");
		}
		List<Rencontre> listRencontres = this.rencontreService.getAllRencontres();
		model.addAttribute("listRencontres", listRencontres);
		return "rencontres";
	}

	@RequestMapping(value = "/delete/{idRencontre}", method = RequestMethod.GET)
	public String deletePronostic(Model model, @PathVariable int idRencontre) {
		this.rencontreService.deleteRencontre(idRencontre);
		return "redirect:/rencontres";
	}

	@RequestMapping(value = "/update/{idRencontre}", method = RequestMethod.GET)
	public String showFormUpdate(Model model, HttpSession session, @PathVariable int idRencontre) {
		Personne personneSession = (Personne) session.getAttribute("personne");
		model.addAttribute("personneSession", personneSession);
		model.addAttribute("page", "modifierRencontre");
		Rencontre rencontre = this.rencontreService.getRencontre(idRencontre);
		model.addAttribute("rencontre", rencontre);
		return "modifierRencontre";
	}

	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	public String updateRencontre(Model model, HttpSession session, HttpServletRequest req) {
		int butEquipe1 = Integer.parseInt(req.getParameter("butEquipe1"));
		int butEquipe2 = Integer.parseInt(req.getParameter("butEquipe2"));
		Rencontre rencontre = this.rencontreService.getRencontre(Integer.parseInt(req.getParameter("idRencontre")));
		rencontre.setButEquipe1(butEquipe1);
		rencontre.setButEquipe2(butEquipe2);
		int status = this.rencontreService.updateRencontre(rencontre);
		System.out.println("status ... " + status);
		if (status > 0) {
			model.addAttribute("msg", "Rencontre bien ajouté");
			model.addAttribute("page", "rencontres");
			this.calculeScoreGlobale();
		}
		return "redirect:/rencontres";
	}

	public Pronostic calculeScorePronostic(Pronostic pronostic) {
		Rencontre rencontre = pronostic.getRencontre();
		if (rencontre.getStatus() == 0) {
			return pronostic;
		}
		if (rencontre.getButEquipe1() == pronostic.getButEquipe1()
				&& rencontre.getButEquipe2() == pronostic.getButEquipe2()) {
			pronostic.setScore(3);
		} else if (rencontre.getButEquipe1() - rencontre.getButEquipe2() == pronostic.getButEquipe1()
				- pronostic.getButEquipe2()) {
			pronostic.setScore(2);
		} else if (rencontre.getButEquipe1() > pronostic.getButEquipe2()
				|| pronostic.getButEquipe1() > rencontre.getButEquipe2()) {
			pronostic.setScore(1);
		}
		return pronostic;
	}

	int scoreGlobal = 0;

	private void calculeScoreGlobale() {
		List<Personne> listPersonne = this.personneService.getAllPersonne();
		listPersonne.forEach(personne -> {
			this.scoreGlobal = 0;
			List<Pronostic> listPronosticParPersonne;
			listPronosticParPersonne = this.pronosticService.getPronosticsByPersonne(personne);
			listPronosticParPersonne.forEach(pronostic -> {
				Pronostic pronosticAvecScore = this.calculeScorePronostic(pronostic);
				this.scoreGlobal += pronosticAvecScore.getScore();
				this.pronosticService.setScore(pronosticAvecScore);
			});
			personne.setScoreGlobal(this.scoreGlobal);
			this.personneService.setScoreGlobal(personne);
		});
	}
}
