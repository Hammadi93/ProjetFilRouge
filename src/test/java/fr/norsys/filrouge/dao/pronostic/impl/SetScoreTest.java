package fr.norsys.filrouge.dao.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.norsys.filrouge.entities.Pronostic;

public class SetScoreTest extends APronosticTest {

	@Test
	public void shouldUpdateAScore() {

		Pronostic pronostic = this.pronosticDao.getPronosticById(1).get();
		pronostic.setScore(34);
		this.pronosticDao.setScore(1, pronostic);

		assertThat(this.pronosticDao.getPronosticById(1).get().getScore()).isEqualTo(34);
	}

}
