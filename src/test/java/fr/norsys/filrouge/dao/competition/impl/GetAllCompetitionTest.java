package fr.norsys.filrouge.dao.competition.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.filrouge.entities.Competition;

public class GetAllCompetitionTest extends ACompetitionDaoTest {

	protected List<Competition> listCompetition;

	@Before
	public void beforeTesting() {
		this.listCompetition = this.competitionDao.getAllCompetitions();
	}

	@Test
	public void shouldGetAllCompetitions() {

		assertThat(this.listCompetition.size()).isEqualTo(2);
	}

	@Test
	public void shouldNotReturnZero() {

		assertThat(this.listCompetition.size()).isGreaterThan(0);
	}

}
