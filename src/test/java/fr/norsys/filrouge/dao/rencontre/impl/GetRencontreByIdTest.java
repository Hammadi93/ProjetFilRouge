
package fr.norsys.filrouge.dao.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.norsys.filrouge.entities.Rencontre;

public class GetRencontreByIdTest extends ARencontreTest {

	@Test
	public void shouldGetRencontreById1() {
		Rencontre rencontre = this.rencontreDao.getRencontreById(1).get();
		assertThat(rencontre.getIdRencontre()).isEqualTo(1);

	}

	
}
