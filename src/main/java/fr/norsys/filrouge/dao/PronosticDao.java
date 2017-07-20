package fr.norsys.filrouge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;
import fr.norsys.filrouge.entities.Rencontre;

@Repository
@Transactional
public interface PronosticDao {

	public void createPronostic(Pronostic pronostic);

	public List<Pronostic> getAllPronostics();

	public Optional<Pronostic> getPronosticById(int id);

	public void setScore(int id, Pronostic pronostic);

	public List<Pronostic> getPronosticsByPersonne(Personne personne);

	public boolean isPronosticsExist(Personne personne, Rencontre rencontre);

	public void deletePronostic(int idPronostic);

	public boolean dejaJouer(Rencontre rencontre);

}
