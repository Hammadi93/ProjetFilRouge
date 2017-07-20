package fr.norsys.filrouge.dao.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DeletePronosticTest extends APronosticTest {

	@Test
	public void shouldDeletePronostic() {
		this.pronosticDao.deletePronostic(1);
		assertThat(this.pronosticDao.getPronosticById(1).get().getIdPronostic()).isEqualTo(0);
	}
}
