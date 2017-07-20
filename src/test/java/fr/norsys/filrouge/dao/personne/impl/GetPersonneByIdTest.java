package fr.norsys.filrouge.dao.personne.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.norsys.filrouge.entities.Personne;

public class GetPersonneByIdTest extends ApersonneTest {

	@Test
	public void shouldGetPersonneById() {
		boolean testExist = this.personneDao.getAllPersonnes().stream().filter(p -> p.getIdPersonne() == 1).findFirst()
				.isPresent();
		;

		assertTrue(testExist);

	}

	@Test
	public void shouldGetPersonneExist() {

		boolean testExist = this.personneDao.getAllPersonnes().stream()
				.filter(p -> p.getNomPersonne().equals("HAMMADI")).findFirst().isPresent();
		;

		assertTrue(testExist);

	}

	@Test
	public void shouldGetPersonneByIdOne() {
		Personne personne = this.personneDao.getPersonneById(1).get();
		assertThat(personne.getIdPersonne()).isEqualTo(1);

	}
}
