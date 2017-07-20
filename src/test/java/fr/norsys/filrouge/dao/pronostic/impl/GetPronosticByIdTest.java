package fr.norsys.filrouge.dao.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;
import fr.norsys.filrouge.entities.Rencontre;

/**
 * @author oudli
 *
 */
public class GetPronosticByIdTest extends APronosticTest {
	@Before
	public void shouldCreatePronostic() {

		Personne personneGiven = this.personneDao.getPersonneById(1).get();
		Rencontre rencontreGiven = this.rencontreDao.getRencontreById(1).get();
		Pronostic pronostic = new Pronostic(1, 1, 1, 10, rencontreGiven, personneGiven);
		this.pronosticDao.createPronostic(pronostic);

	}

	@Test
	public void shouldReturnOne() {

		Pronostic pronosticGiven = this.pronosticDao.getPronosticById(1).get();
		assertThat(pronosticGiven.getIdPronostic()).isEqualTo(1);
	}

}
