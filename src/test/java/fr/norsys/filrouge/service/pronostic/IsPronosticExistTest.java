package fr.norsys.filrouge.service.pronostic;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Rencontre;

public class IsPronosticExistTest extends APronosticServiceTest {

	@Test
	public void shouldPronosticExist() {
		Optional<Rencontre> rencontre = Optional.of(new Rencontre());
		rencontre.get().setIdRencontre(5);
		Optional<Personne> personne = Optional.of(new Personne());
		personne.get().setIdPersonne(8);
		doReturn(true).when(this.mockPronosticDAO).isPronosticsExist(personne.get(), rencontre.get());
	}

}
