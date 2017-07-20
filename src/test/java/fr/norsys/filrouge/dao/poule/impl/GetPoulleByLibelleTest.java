package fr.norsys.filrouge.dao.poule.impl;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Poule;


public class GetPoulleByLibelleTest extends APouleTest {

	@Test
	public void shouldGetPolleByLibelleA() {
		Optional<Poule> poule = this.pouleDao.getPoulleById(1);
		assertThat(poule.get().getLibellePoulle()).isEqualTo("A");
	}

}
