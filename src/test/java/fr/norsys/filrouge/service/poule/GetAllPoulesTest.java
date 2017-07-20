package fr.norsys.filrouge.service.poule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.filrouge.entities.Poule;

public class GetAllPoulesTest extends APouleServiceTest {

	@Test
	public void shoudReturnAllRencontres() {
		List<Poule> poules = Arrays.asList(new Poule(), new Poule());
		doReturn(poules).when(this.mockPouleDAO).getAllPoulles();
		assertThat(this.pouleService.getAllPoulles().stream().count()).isEqualTo(poules.stream().count());
		verify(this.mockPouleDAO, times(1)).getAllPoulles();
	}
}
