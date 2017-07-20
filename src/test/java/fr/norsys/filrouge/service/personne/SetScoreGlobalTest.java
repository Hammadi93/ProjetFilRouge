package fr.norsys.filrouge.service.personne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;

public class SetScoreGlobalTest extends APersonneServiceTest {

	@Test
	public void shouldSetScoreGlobal() {
		Optional<Personne> personne = Optional.of(new Personne());
		personne.get().setScoreGlobal(4);
		doReturn(personne).when(this.mockPersonneDAO).getPersonneById(personne.get().getIdPersonne());
		assertThat(this.personneService.getPersonne(personne.get().getIdPersonne()).getScoreGlobal())
		        .isEqualTo(personne.get().getScoreGlobal());
		verify(this.mockPersonneDAO, times(1)).getPersonneById(personne.get().getIdPersonne());
	}

}
