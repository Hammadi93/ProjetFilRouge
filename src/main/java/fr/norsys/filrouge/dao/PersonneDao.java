package fr.norsys.filrouge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Personne;

@Repository
@Transactional
public interface PersonneDao {

	public List<Personne> getAllPersonnes();

	public Optional<Personne> getPersonneById(int id);

	public void setScoreGlobal(Personne personne);

	public boolean validerUtilusateur(String user, String password);

	Optional<Personne> getPersonneByEmail(String email);

}
