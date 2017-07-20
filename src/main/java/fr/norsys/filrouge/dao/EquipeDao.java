package fr.norsys.filrouge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Equipe;
import fr.norsys.filrouge.entities.Poule;

@Repository
@Transactional
public interface EquipeDao {

	public List<Equipe> getAllEquipes();

	public Optional<Equipe> getEquipeById(int id);

	public List<Equipe> getAllByPoulle(Poule poulle);

	int createEquipe(Equipe equipe);

}
