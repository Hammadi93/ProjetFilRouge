package fr.norsys.filrouge.dao.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.filrouge.entities.Rencontre;

public class UpdateRencontreTest extends ARencontreTest {
	protected Rencontre rencontre;
	
	@Before
	public void beforeThisClass() {
		 rencontre = this.rencontreDao.getRencontreById(1).get();
		rencontre.setStatus(1);
	}

	@Test
	public void shouldUpdateRencontre() {

		int valuetDelete = this.rencontreDao.updateRencontre(rencontre);
		assertThat(valuetDelete).isEqualTo(1);

	}

	

}
