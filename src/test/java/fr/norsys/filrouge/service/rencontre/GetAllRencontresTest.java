package fr.norsys.filrouge.service.rencontre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.filrouge.entities.Rencontre;

public class GetAllRencontresTest extends ARencontreServiceTest {

	@Test
	public void shoudReturnAllRencontres() {
		List<Rencontre> rencontres = Arrays.asList(new Rencontre(), new Rencontre());
		doReturn(rencontres).when(this.mockRencontreDAO).getAllRencontres();
		assertThat(this.rencontreService.getAllRencontres().stream().count()).isEqualTo(rencontres.stream().count());
		verify(this.mockRencontreDAO, times(1)).getAllRencontres();
	}
}
