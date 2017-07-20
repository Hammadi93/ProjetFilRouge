package fr.norsys.filrouge.dao.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.filrouge.entities.Pronostic;

public class GetAllPronosticTest extends APronosticTest {

	protected List<Pronostic> lstPronostic;

	@Before
	public void beforeTesting() {
		this.lstPronostic = this.pronosticDao.getAllPronostics();
	}

	@Test
	public void shouldGetAllPronostics() {

		assertThat(this.lstPronostic.stream().count()).isEqualTo(4);
	}



}
