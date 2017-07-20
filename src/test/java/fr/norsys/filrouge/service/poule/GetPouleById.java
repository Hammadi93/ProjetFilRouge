package fr.norsys.filrouge.service.poule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Poule;

public class GetPouleById extends APouleServiceTest {

	@Test
	public void shouldGetById() {
		Optional<Poule> poule = Optional.of(new Poule());
		poule.get().setIdPoulle(1);
		doReturn(poule).when(this.mockPouleDAO).getPoulleById(1);
		assertThat(this.pouleService.getPoulle(1).get().getIdPoulle()).isEqualTo(poule.get().getIdPoulle());
		verify(this.mockPouleDAO, times(1)).getPoulleById(1);
	}
}
