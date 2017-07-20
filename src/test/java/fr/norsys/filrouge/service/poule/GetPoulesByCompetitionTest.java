package fr.norsys.filrouge.service.poule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.filrouge.entities.Poule;

public class GetPoulesByCompetitionTest extends APouleServiceTest {

	@Test
	public void shoudReturnPoulesByCompetition() {
		List<Poule> poulesByCompetition = Arrays.asList(new Poule(), new Poule());
		doReturn(poulesByCompetition).when(this.mockPouleDAO).getAllPoullesByCompetition(anyInt());
		assertThat(this.pouleService.getAllPoullesByCompetition(anyInt()).stream().count())
		        .isEqualTo(poulesByCompetition.stream().count());
		verify(this.mockPouleDAO, times(1)).getAllPoullesByCompetition(anyInt());
	}
}
