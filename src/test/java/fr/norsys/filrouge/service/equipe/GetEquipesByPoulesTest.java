package fr.norsys.filrouge.service.equipe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.filrouge.entities.Competition;
import fr.norsys.filrouge.entities.Equipe;
import fr.norsys.filrouge.entities.Poule;

public class GetEquipesByPoulesTest extends AEquipeServiceTest {

	@Test
	public void shoudReturnEquipesByPoule() {
		Competition competition = new Competition(1, "CAN");
		Poule poule = new Poule(1, "A", competition);
		List<Equipe> equipesByPoule = Arrays.asList(new Equipe(), new Equipe());
		doReturn(equipesByPoule).when(this.mockEquipeDAO).getAllByPoulle(poule);
		assertThat(this.equipeService.getAllByPoulle(poule).stream().count())
		        .isEqualTo(equipesByPoule.stream().count());
		verify(this.mockEquipeDAO, times(1)).getAllByPoulle(poule);
	}
}
