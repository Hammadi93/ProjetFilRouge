package fr.norsys.filrouge.service.competition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Competition;

public class GetCompetitionById extends ACompetitionServiceTest {

	@Test
	public void shouldGetById() {
		Optional<Competition> competition = Optional.of(new Competition());
		competition.get().setIdCompetition(1);
		doReturn(competition).when(this.mockCompetitionDAO).getCompetitionById(1);
		assertThat(this.competitionService.getCompetition(1).get().getIdCompetition())
		        .isEqualTo(competition.get().getIdCompetition());
		verify(this.mockCompetitionDAO, times(1)).getCompetitionById(1);
	}
}
