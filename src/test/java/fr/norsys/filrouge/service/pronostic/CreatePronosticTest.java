package fr.norsys.filrouge.service.pronostic;

import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;
import fr.norsys.filrouge.entities.Rencontre;

public class CreatePronosticTest extends APronosticServiceTest {

	@Test
	public void shoudCreatePronostic() {
		Rencontre rencontre = new Rencontre();
		Personne personne = new Personne();
		Pronostic pronostic = new Pronostic(12, 2, 1, 10, rencontre, personne);
		this.pronosticService.createPronostic(pronostic);
	}

}
