package fr.norsys.filrouge.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Personne;

@Service
@Transactional
public interface PersonneService {

	public Personne getPersonne(int id);

	public Personne getPersonne(String email);

	public List<Personne> getAllPersonne();

	public void setScoreGlobal(Personne personne);

	public boolean validerUtilusateur(String user, String password);
}
