package fr.norsys.filrouge.service.personne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;

public class GetPersonneById extends APersonneServiceTest {

	@Test
	public void shouldGetById() {
		Optional<Personne> personne = Optional.of(new Personne());
		personne.get().setIdPersonne(1);
		doReturn(personne).when(this.mockPersonneDAO).getPersonneById(1);
		assertThat(this.personneService.getPersonne(1).getIdPersonne()).isEqualTo(personne.get().getIdPersonne());
		verify(this.mockPersonneDAO, times(1)).getPersonneById(1);
	}
}
