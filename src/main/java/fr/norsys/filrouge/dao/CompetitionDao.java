package fr.norsys.filrouge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Competition;

@Repository
@Transactional
public interface CompetitionDao {

	public List<Competition> getAllCompetitions();

	public Optional<Competition> getCompetitionById(int id);

}
