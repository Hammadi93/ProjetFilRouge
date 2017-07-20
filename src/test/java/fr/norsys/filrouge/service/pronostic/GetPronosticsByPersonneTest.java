package fr.norsys.filrouge.service.pronostic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;

public class GetPronosticsByPersonneTest extends APronosticServiceTest {

	@Test
	public void shoudReturnAllPronostics() {
		Personne personne = new Personne(1, "ALI", "Salim", "salima@norsys.fr", "salim", "ROLE_SALARIE", 0);
		List<Pronostic> pronosticsByPersonne = Arrays.asList(new Pronostic(), new Pronostic());
		doReturn(pronosticsByPersonne).when(this.mockPronosticDAO).getPronosticsByPersonne(personne);
		assertThat(this.pronosticService.getPronosticsByPersonne(personne).stream().count())
		        .isEqualTo(pronosticsByPersonne.stream().count());
		verify(this.mockPronosticDAO, times(1)).getPronosticsByPersonne(personne);
	}
}
