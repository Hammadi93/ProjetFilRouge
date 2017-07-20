package fr.norsys.filrouge.dao.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DeleteRencontreTest extends ARencontreTest {

	@Test
	public void shouldDeleteRencontre() {
		this.rencontreDao.deleteRencontre(3);
		assertThat(this.rencontreDao.getRencontreById(3).get().getIdRencontre()).isEqualTo(0);

	}

}
