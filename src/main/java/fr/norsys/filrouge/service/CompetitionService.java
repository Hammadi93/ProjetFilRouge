package fr.norsys.filrouge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.entities.Competition;

@Service
@Transactional
public interface CompetitionService {

	public Optional<Competition> getCompetition(int id);

	public List<Competition> getAllCompetitions();
}
