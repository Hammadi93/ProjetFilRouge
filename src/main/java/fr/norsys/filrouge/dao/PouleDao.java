package fr.norsys.filrouge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Poule;

@Repository
@Transactional
public interface PouleDao {
	public Optional<Poule> getPoulleById(int id);

	public List<Poule> getAllPoullesByCompetition(int idCompetition);

	List<Poule> getAllPoulles();

}
