package fr.norsys.filrouge.dao.personne.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ValidateUserTest extends ApersonneTest {

	@Test
	public void shouldValidateUser() {

		boolean personneValidate = this.personneDao.validerUtilusateur("ooudli@norsys.fr", "wijwij");

		assertThat(personneValidate).isEqualTo(true);

	}

}
