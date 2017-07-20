
package fr.norsys.filrouge.dao.personne.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SetScoreGlobal extends ApersonneTest {

	@Test
	public void shouldUpdateTheScore() {
		this.personneDao.setScoreGlobal(this.personneDao.getPersonneById(1).get());
		int score = this.personneDao.getPersonneById(1).get().getScoreGlobal();

		assertThat(score).isEqualTo(0);
	}

}
