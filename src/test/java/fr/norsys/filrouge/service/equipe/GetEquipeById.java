package fr.norsys.filrouge.service.equipe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Equipe;

public class GetEquipeById extends AEquipeServiceTest {

	@Test
	public void shouldGetById() {
		Optional<Equipe> equipe = Optional.of(new Equipe());
		equipe.get().setIdEquipe(1);
		doReturn(equipe).when(this.mockEquipeDAO).getEquipeById(1);
		assertThat(this.equipeService.getEquipe(1).get().getIdEquipe()).isEqualTo(equipe.get().getIdEquipe());
		verify(this.mockEquipeDAO, times(1)).getEquipeById(1);
	}
}
