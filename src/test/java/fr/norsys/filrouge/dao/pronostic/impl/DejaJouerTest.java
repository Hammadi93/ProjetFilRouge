package fr.norsys.filrouge.dao.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import fr.norsys.filrouge.entities.Rencontre;

public class DejaJouerTest extends APronosticTest {

	@Test
	public void shouldReturnTrue() {
		
		Rencontre rencontre=this.rencontreDao.getRencontreById(1).get();
		rencontre.setStatus(1);
		assertThat(this.pronosticDao.dejaJouer(rencontre)).isEqualTo(false);
	}

}
