package fr.norsys.filrouge.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;
import fr.norsys.filrouge.entities.Rencontre;

@Transactional
@Service
public interface PronosticService {
	public Pronostic getPronostic(int id);

	public List<Pronostic> getAllPronostics();

	public List<Pronostic> getPronosticsByPersonne(Personne personne);

	public void createPronostic(Pronostic pronostic);

	public void setScore(Pronostic pronostic);

	public boolean isPronosticsExist(Personne personne, Rencontre rencontre);

	public void deletePronostic(int idPronostic);

	public boolean dejaJouer(Rencontre rencontre);

}
