package fr.norsys.filrouge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.dao.CompetitionDao;
import fr.norsys.filrouge.entities.Competition;
import fr.norsys.filrouge.service.CompetitionService;

@Service
@Transactional
public class CompetitionServiceImp implements CompetitionService {

	@Autowired
	private CompetitionDao competitionDao;

	public CompetitionServiceImp(CompetitionDao competitionDao) {
		this.competitionDao = competitionDao;
	}

	public CompetitionServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Optional<Competition> getCompetition(int id) {
		return this.competitionDao.getCompetitionById(id);
	}

	@Override
	public List<Competition> getAllCompetitions() {
		return this.competitionDao.getAllCompetitions();
	}
}
