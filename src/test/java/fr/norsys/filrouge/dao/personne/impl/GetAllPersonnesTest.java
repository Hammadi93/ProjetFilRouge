package fr.norsys.filrouge.dao.personne.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;

public class GetAllPersonnesTest extends ApersonneTest {

	protected List<Personne> lstPersonnes;

	@Before
	public void beforeTesting() {
		this.lstPersonnes = this.personneDao.getAllPersonnes();
	}

	@Test
	public void shouldGetAllPersonnes() {

		assertThat(this.lstPersonnes.stream().count()).isEqualTo(3);
	}

	@Test
	public void shouldNotReturnZero() {

		assertThat(this.lstPersonnes.stream().count()).isGreaterThan(0);
	}

}
