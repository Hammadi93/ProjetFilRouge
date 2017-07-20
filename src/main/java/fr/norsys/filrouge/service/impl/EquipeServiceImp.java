package fr.norsys.filrouge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.dao.EquipeDao;
import fr.norsys.filrouge.entities.Equipe;
import fr.norsys.filrouge.entities.Poule;
import fr.norsys.filrouge.service.EquipeService;

@Service
@Transactional
public class EquipeServiceImp implements EquipeService {

	@Autowired
	private EquipeDao equipeDao;

	public EquipeServiceImp(EquipeDao equipeDao) {
		this.equipeDao = equipeDao;
	}

	@Override
	public Optional<Equipe> getEquipe(int id) {
		return this.equipeDao.getEquipeById(id);
	}

	@Override
	public List<Equipe> getAllEquipes() {
		return this.equipeDao.getAllEquipes();
	}

	@Override
	public List<Equipe> getAllByPoulle(Poule poulle) {
		return this.equipeDao.getAllByPoulle(poulle);
	}

}
