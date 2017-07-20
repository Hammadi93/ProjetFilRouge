package fr.norsys.filrouge.service.competition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.filrouge.entities.Competition;

public class GetAllCompetitionsTest extends ACompetitionServiceTest {

	@Test
	public void shoudReturnAllRencontres() {
		List<Competition> competitions = Arrays.asList(new Competition(), new Competition());
		doReturn(competitions).when(this.mockCompetitionDAO).getAllCompetitions();
		assertThat(this.competitionService.getAllCompetitions().stream().count())
		        .isEqualTo(competitions.stream().count());
		verify(this.mockCompetitionDAO, times(1)).getAllCompetitions();
	}
}
