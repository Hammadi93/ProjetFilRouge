package fr.norsys.filrouge.dao.poule.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Poule;


public class GetPolleByIdTest extends APouleTest {
	
	@Test
	public void shouldGetPolleById() {
		Optional<Poule> poule = this.pouleDao.getPoulleById(1);
		assertThat(poule.get().getLibellePoulle()).isEqualTo("A");
	}

	@Test
	public void shouldGetPolleByIdOne() {
		Optional<Poule> poule = this.pouleDao.getPoulleById(1);
		assertThat(poule.get().getIdPoulle()).isEqualTo(1);

	}
}
