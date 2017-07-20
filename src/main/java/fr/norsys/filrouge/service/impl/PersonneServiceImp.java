package fr.norsys.filrouge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.dao.PersonneDao;
import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.service.PersonneService;

@Service
@Transactional
public class PersonneServiceImp implements PersonneService {
	@Autowired
	private PersonneDao personneDao;

	public PersonneServiceImp(PersonneDao personneDao) {
		this.personneDao = personneDao;
	}

	@Override
	public Personne getPersonne(int id) {
		return this.personneDao.getPersonneById(id).get();
	}

	@Override
	public Personne getPersonne(String email) {
		return this.personneDao.getPersonneByEmail(email).get();
	}

	@Override
	public List<Personne> getAllPersonne() {
		return this.personneDao.getAllPersonnes();
	}

	@Override
	public void setScoreGlobal(Personne personne) {
		this.personneDao.setScoreGlobal(personne);
	}

	@Override
	public boolean validerUtilusateur(String user, String password) {
		return this.personneDao.validerUtilusateur(user, password);
	}
}
