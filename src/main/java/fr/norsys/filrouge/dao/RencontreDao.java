package fr.norsys.filrouge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Poule;
import fr.norsys.filrouge.entities.Rencontre;

@Repository
@Transactional
public interface RencontreDao {

	public List<Rencontre> getAllRencontres();

	public List<Rencontre> getAllRencontresByPolle(Poule polle);

	public Optional<Rencontre> getRencontreById(int id);

	public int createRencontre(Rencontre rencontre);

	public int deleteRencontre(int id);

	public int updateRencontre(Rencontre rencontre);

}
