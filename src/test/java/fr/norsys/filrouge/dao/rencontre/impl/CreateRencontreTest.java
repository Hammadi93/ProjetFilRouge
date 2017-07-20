package fr.norsys.filrouge.dao.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.Test;

import fr.norsys.filrouge.entities.Rencontre;

public class CreateRencontreTest extends ARencontreTest {

	@Test
	public void shouldCreateRencontre() {

		Rencontre rencontreGiven = new Rencontre(13, new Timestamp(0), null, 1, 1, 1,
				this.equipeDao.getEquipeById(1).get(), this.equipeDao.getEquipeById(2).get(),
				this.pouleDao.getPoulleById(2).get(), this.competitionDao.getCompetitionById(1).get());

		int resultCreation = this.rencontreDao.createRencontre(rencontreGiven);

		assertThat(resultCreation).isNotEqualTo(0);
		assertThat(this.rencontreDao.getRencontreById(13).get().getIdRencontre()).isEqualTo(13);

	}
}
