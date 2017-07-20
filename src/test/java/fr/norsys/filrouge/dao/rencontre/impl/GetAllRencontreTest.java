package fr.norsys.filrouge.dao.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.filrouge.entities.Rencontre;

public class GetAllRencontreTest extends ARencontreTest {

	protected List<Rencontre> lstRencontres;

	@Before
	public void beforeTesting() {
		this.lstRencontres = this.rencontreDao.getAllRencontres();
	}

	@Test
	public void shouldGetAllRencontres() {

		assertThat(this.lstRencontres.size()).isEqualTo(5);
	}

	@Test
	public void shouldNotReturnZero() {

		assertThat(this.lstRencontres.size()).isGreaterThan(0);
	}

}
