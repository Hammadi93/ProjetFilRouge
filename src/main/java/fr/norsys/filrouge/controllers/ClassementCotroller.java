package fr.norsys.filrouge.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.service.PersonneService;

@Controller
@RequestMapping("/classement")
public class ClassementCotroller {
	@Autowired
	PersonneService personneService;

	@RequestMapping(value = "")
	public String classement(Model model, HttpSession session) {
		List<Personne> listPersonnes = this.personneService.getAllPersonne();
		Personne personneSession = (Personne) session.getAttribute("personne");
		model.addAttribute("personneSession", personneSession);
		model.addAttribute("listPersonnes", listPersonnes);
		model.addAttribute("page", "classement");
		return "classement";
	}
}
