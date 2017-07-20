package fr.norsys.filrouge.dao.poule.impl;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import fr.norsys.filrouge.entities.Poule;


public class GetAllPoullesByCompetitionTest extends APouleTest {

	
	protected List<Poule> lstPoules;
	@Test
	public void shouldGetPouleByCompetition() {
	
	}
	
	@Before
	public void beforeTesting() {

		this.lstPoules = this.pouleDao.getAllPoullesByCompetition(1);
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
