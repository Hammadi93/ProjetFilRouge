package fr.norsys.filrouge.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Poule;
import fr.norsys.filrouge.entities.Rencontre;

@Service
@Transactional
public interface RencontreService {

	public Rencontre getRencontre(int id);

	public List<Rencontre> getAllRencontres();

	public int createRencontre(Rencontre rencontre);

	public int deleteRencontre(int id);

	public int updateRencontre(Rencontre rencontre);

	public List<Rencontre> getAllRencontresByPolle(Poule polle);

}