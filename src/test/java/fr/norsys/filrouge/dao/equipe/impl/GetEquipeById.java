package fr.norsys.filrouge.dao.equipe.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.filrouge.entities.Equipe;

public class GetEquipeById extends AEquipeTest {

	@Test
	public void shouldGetEquipeById() {
		Optional<Equipe> equipe = this.equipeDao.getEquipeById(2);
		assertThat(equipe.get().getLibelleEquipe()).isEqualTo("Algerie");

	}

	@Test
	public void shouldGetEquipeByIdOne() {
		Optional<Equipe> equipe = this.equipeDao.getEquipeById(1);
		assertThat(equipe.get().getIdEquipe()).isEqualTo(1);

	}
}
