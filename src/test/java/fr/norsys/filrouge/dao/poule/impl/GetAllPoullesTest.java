package fr.norsys.filrouge.dao.poule.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.filrouge.entities.Poule;


public class GetAllPoullesTest extends APouleTest {
	protected List<Poule> lstPoules;

	@Before
	public void beforeTesting() {

		this.lstPoules = this.pouleDao.getAllPoulles();
	}

	@Test
	public void shouldGetAllPolles() {

		assertThat(this.lstPoules.stream().count()).isEqualTo(2);
	}

	@Test
	public void shouldNotReturnZero() {

		assertThat(this.lstPoules.stream().count()).isGreaterThan(0);
	}

}
