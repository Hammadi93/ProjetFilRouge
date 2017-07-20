package fr.norsys.filrouge.service.personne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;

public class GetAllPersonnesTest extends APersonneServiceTest {

	@Test
	public void shoudReturnAllEquipes() {
		List<Personne> personnes = Arrays.asList(new Personne(), new Personne());
		doReturn(personnes).when(this.mockPersonneDAO).getAllPersonnes();
		assertThat(this.personneService.getAllPersonne().stream().count()).isEqualTo(personnes.stream().count());
		verify(this.mockPersonneDAO, times(1)).getAllPersonnes();
	}
}
