package fr.norsys.filrouge.service.pronostic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.filrouge.entities.Pronostic;

public class GetAllPronosticTest extends APronosticServiceTest {

	@Test
	public void shoudReturnAllPronostics() {
		List<Pronostic> pronostics = Arrays.asList(new Pronostic(), new Pronostic());
		doReturn(pronostics).when(this.mockPronosticDAO).getAllPronostics();
		assertThat(this.pronosticService.getAllPronostics().stream().count()).isEqualTo(pronostics.stream().count());
		verify(this.mockPronosticDAO, times(1)).getAllPronostics();
	}
}
