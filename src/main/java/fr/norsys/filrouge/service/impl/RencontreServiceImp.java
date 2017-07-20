package fr.norsys.filrouge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.dao.RencontreDao;
import fr.norsys.filrouge.entities.Poule;
import fr.norsys.filrouge.entities.Rencontre;
import fr.norsys.filrouge.service.RencontreService;

@Service
@Transactional
public class RencontreServiceImp implements RencontreService {
	@Autowired
	private RencontreDao rencontreDao;

	public RencontreServiceImp(RencontreDao rencontreDao) {
		this.rencontreDao = rencontreDao;
	}

	@Override
	public Rencontre getRencontre(int id) {
		return this.rencontreDao.getRencontreById(id).get();
	}

	@Override
	public List<Rencontre> getAllRencontres() {
		return this.rencontreDao.getAllRencontres();
	}

	@Override
	public int createRencontre(Rencontre rencontre) {
		return this.rencontreDao.createRencontre(rencontre);
	}

	@Override
	public int deleteRencontre(int id) {
		return this.rencontreDao.deleteRencontre(id);
	}

	@Override
	public int updateRencontre(Rencontre rencontre) {
		return this.rencontreDao.updateRencontre(rencontre);
	}

	@Override
	public List<Rencontre> getAllRencontresByPolle(Poule polle) {
		// TODO Auto-generated method stub
		return this.rencontreDao.getAllRencontresByPolle(polle);
	}
}