package fr.norsys.filrouge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Poule;

@Service
@Transactional
public interface PouleService {

	public Optional<Poule> getPoulle(int id);

	public List<Poule> getAllPoullesByCompetition(int idCompetition);

	public List<Poule> getAllPoulles();

}