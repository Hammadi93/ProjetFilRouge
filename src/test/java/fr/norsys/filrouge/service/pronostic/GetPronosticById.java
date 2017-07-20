package fr.norsys.filrouge.service.pronostic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Pronostic;

public class GetPronosticById extends APronosticServiceTest {

	@Test
	public void shouldGetById() {
		Optional<Pronostic> pronostic = Optional.of(new Pronostic());
		pronostic.get().setIdPronostic(1);
		doReturn(pronostic).when(this.mockPronosticDAO).getPronosticById(1);
		assertThat(this.pronosticService.getPronostic(1).getIdPronostic()).isEqualTo(pronostic.get().getIdPronostic());
		verify(this.mockPronosticDAO, times(1)).getPronosticById(1);
	}
}
