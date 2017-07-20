package fr.norsys.filrouge.service.personne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;

public class ValiderUtilusateurTest extends APersonneServiceTest {

	@Test
	public void shouldValiderUtilusateur() {
		Optional<Personne> personne = Optional.of(new Personne());
		personne.get().setEmail("hammadi@gmail.com");
		personne.get().setPassword("norsysAfrique");
		doReturn(true).when(this.mockPersonneDAO).validerUtilusateur("hammadi@gmail.com", "norsysAfrique");
		assertThat(this.personneService.validerUtilusateur("hammadi@gmail.com", "norsysAfrique"));
	}
}
