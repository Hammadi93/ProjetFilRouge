package fr.norsys.filrouge.service.equipe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.filrouge.entities.Equipe;

public class GetAllEquipesTest extends AEquipeServiceTest {

	@Test
	public void shoudReturnAllEquipes() {
		List<Equipe> equipes = Arrays.asList(new Equipe(), new Equipe());
		doReturn(equipes).when(this.mockEquipeDAO).getAllEquipes();
		assertThat(this.equipeService.getAllEquipes().stream().count()).isEqualTo(equipes.stream().count());
		verify(this.mockEquipeDAO, times(1)).getAllEquipes();
	}
}
