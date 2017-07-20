package fr.norsys.filrouge.dao.pronostic.impl;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;
import fr.norsys.filrouge.entities.Rencontre;


public class CreatePronosticTest extends APronosticTest {

	@Test
	public void shouldCreatePronostic()  {
		Personne personneGiven = this.personneDao.getPersonneById(2).get();
		Rencontre rencontreGiven = this.rencontreDao.getRencontreById(2).get();
		Pronostic pronostic = new Pronostic(1, 2, 3, 2, rencontreGiven, personneGiven);
		this.pronosticDao.createPronostic(pronostic);
		assertThat(this.pronosticDao.getPronosticsByPersonne(personneGiven).size()).isEqualTo(1);

	}
	


}
