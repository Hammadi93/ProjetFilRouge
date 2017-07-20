package fr.norsys.filrouge.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.norsys.filrouge.service.PersonneService;

@Controller
@RequestMapping("")
public class AuthentificationController {

	@Autowired
	PersonneService		personneService;
	final static Logger	logger	= Logger.getLogger(AuthentificationController.class);

	@RequestMapping(value = "/login")
	public String loginGet(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "user", "password" })
	public String login(Model model, HttpSession session, @RequestParam(value = "user") String user,
	        @RequestParam(value = "password") String password) {
		if (user == null || password == null) {
			model.addAttribute("erreur", "<font color=red><center>Email ou mot de passe vide!!</center></font>");
		}
		if (this.personneService.validerUtilusateur(user, password)) {
			session.setAttribute("personne", this.personneService.getPersonne(user));
			return "redirect:competitions";
		} else {
			model.addAttribute("erreur", "<font color=red><center>Email ou mot de passe incorrect!!</center></font>");
		}
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("personne");
		return "redirect:login?next";
	}

}
