package fr.norsys.filrouge.dao.equipe.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.filrouge.entities.Equipe;

public class GetAllEquipe extends AEquipeTest {
	protected List<Equipe> lstEquipes;

	@Before
	public void beforeTesting() {
		this.lstEquipes = this.equipeDao.getAllEquipes();
	}

	@Test
	public void shouldGetAllEquipe() {

		assertThat(this.lstEquipes.size()).isEqualTo(8);
	}

	@Test
	public void shouldNotReturnZero() {

		assertThat(this.lstEquipes.size()).isGreaterThan(0);
	}

}
