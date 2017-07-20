package fr.norsys.filrouge.service.personne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;

public class GetPersonneByEmailTest extends APersonneServiceTest {

	@Test
	public void shouldGetPersonneByEmailTest() {
		Optional<Personne> personne = Optional.of(new Personne());
		personne.get().setEmail("hammadi@gmail.com");
		doReturn(personne).when(this.mockPersonneDAO).getPersonneByEmail("hammadi@gmail.com");
		assertThat(this.personneService.getPersonne("hammadi@gmail.com").getEmail())
		        .isEqualTo(personne.get().getEmail());
		verify(this.mockPersonneDAO, times(1)).getPersonneByEmail("hammadi@gmail.com");
	}
}
