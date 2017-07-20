package fr.norsys.filrouge.service.rencontre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.junit.Test;

import fr.norsys.filrouge.entities.Rencontre;

public class GetRencontreById extends ARencontreServiceTest {
	final static Logger logger = Logger.getLogger(GetRencontreById.class);

	@Test
	public void shouldGetById() {
		Optional<Rencontre> rencontre = Optional.of(new Rencontre());
		rencontre.get().setIdRencontre(1);
		doReturn(rencontre).when(this.mockRencontreDAO).getRencontreById(1);
		assertThat(this.rencontreService.getRencontre(1).getIdRencontre()).isEqualTo(rencontre.get().getIdRencontre());
		verify(this.mockRencontreDAO, times(1)).getRencontreById(1);
	}
}
