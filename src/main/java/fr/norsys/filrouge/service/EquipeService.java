package fr.norsys.filrouge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Equipe;
import fr.norsys.filrouge.entities.Poule;

@Service
@Transactional
public interface EquipeService {

	public Optional<Equipe> getEquipe(int id);

	public List<Equipe> getAllEquipes();

	public List<Equipe> getAllByPoulle(Poule poulle);

}
