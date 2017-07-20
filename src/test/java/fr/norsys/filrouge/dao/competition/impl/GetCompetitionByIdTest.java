package fr.norsys.filrouge.dao.competition.impl;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import org.junit.Test;
import fr.norsys.filrouge.entities.Competition;

public class GetCompetitionByIdTest extends ACompetitionDaoTest {


	@Test
	public void shouldGetCompetitionByIdOne() {
		Optional<Competition> comp = this.competitionDao.getCompetitionById(1);
		assertThat(comp.get().getIdCompetition()).isEqualTo(1);

	}
	@Test
	public void shouldGetCompetitionById() {
		Optional<Competition> comp = this.competitionDao.getCompetitionById(1);
		assertThat(comp.get().getLibelleCompetition()).isEqualTo("CAN");

	}
	

}
