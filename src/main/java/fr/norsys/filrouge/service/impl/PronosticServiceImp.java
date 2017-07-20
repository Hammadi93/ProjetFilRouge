package fr.norsys.filrouge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.dao.PronosticDao;
import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;
import fr.norsys.filrouge.entities.Rencontre;
import fr.norsys.filrouge.service.PronosticService;

@Service
@Transactional
public class PronosticServiceImp implements PronosticService {

	@Autowired
	private PronosticDao pronosticDao;

	public PronosticServiceImp(PronosticDao pronosticDao) {
		this.pronosticDao = pronosticDao;
	}

	public PronosticServiceImp() {

	}

	@Override
	public Pronostic getPronostic(int id) {
		return this.pronosticDao.getPronosticById(id).get();
	}

	@Override
	public List<Pronostic> getAllPronostics() {
		return this.pronosticDao.getAllPronostics();
	}

	@Override
	public List<Pronostic> getPronosticsByPersonne(Personne personne) {
		return this.pronosticDao.getPronosticsByPersonne(personne);
	}

	@Override
	public void createPronostic(Pronostic pronostic) {
		this.pronosticDao.createPronostic(pronostic);
	}

	@Override
	public void setScore(Pronostic pronostic) {
		this.pronosticDao.setScore(pronostic.getIdPronostic(), pronostic);
	}

	@Override

	public boolean isPronosticsExist(Personne personne, Rencontre rencontre) {

		return this.pronosticDao.isPronosticsExist(personne, rencontre);
	}

	public void deletePronostic(int idPronostic) {
		this.pronosticDao.deletePronostic(idPronostic);
	}

	@Override
	public boolean dejaJouer(Rencontre rencontre) {

		return this.pronosticDao.dejaJouer(rencontre);
	}
}
