package fr.norsys.filrouge.service.pronostic;

import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;
import fr.norsys.filrouge.entities.Rencontre;

public class SetScoreTest extends APronosticServiceTest {

	@Test
	public void shoudSetScore() {
		Rencontre rencontre = new Rencontre();
		Personne personne = new Personne();
		Pronostic pronostic = new Pronostic(12, 2, 1, 10, rencontre, personne);
		pronostic.setScore(7);
		pronosticService.setScore(pronostic);
	}
}
