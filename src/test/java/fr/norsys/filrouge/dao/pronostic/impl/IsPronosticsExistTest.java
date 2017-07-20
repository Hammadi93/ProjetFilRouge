package fr.norsys.filrouge.dao.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class IsPronosticsExistTest extends APronosticTest {

	@Test
	public void shouldReturnTrue() {
		assertThat(this.pronosticDao.isPronosticsExist(this.personneDao.getPersonneById(1).get(),
				this.rencontreDao.getRencontreById(1).get())).isEqualTo(true);
	}

}
