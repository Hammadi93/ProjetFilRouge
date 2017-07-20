package fr.norsys.filrouge.dao.equipe.impl;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import fr.norsys.filrouge.entities.Equipe;


public class CreateEquipeTest extends AEquipeTest{

	@Test
	public void shouldCreateEquipe()  {
		Equipe equipeGiven = new Equipe(34, "equipe",null, 1);
		
		this.equipeDao.createEquipe(equipeGiven);
		
		assertThat(this.equipeDao.getEquipeById(34).get()).isNotNull();

	}

}
