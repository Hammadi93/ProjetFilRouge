package fr.norsys.filrouge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.dao.PouleDao;
import fr.norsys.filrouge.entities.Poule;
import fr.norsys.filrouge.service.PouleService;

@Service
@Transactional
public class PouleServiceImp implements PouleService {
	@Autowired
	private PouleDao poulleDao;

	public PouleServiceImp(PouleDao poulleDao) {
		this.poulleDao = poulleDao;
	}

	@Override
	public Optional<Poule> getPoulle(int id) {
		return this.poulleDao.getPoulleById(id);
	}

	@Override
	public List<Poule> getAllPoullesByCompetition(int idCompetition) {
		return this.poulleDao.getAllPoullesByCompetition(idCompetition);
	}

	@Override
	public List<Poule> getAllPoulles() {
		return this.poulleDao.getAllPoulles();
	}

}