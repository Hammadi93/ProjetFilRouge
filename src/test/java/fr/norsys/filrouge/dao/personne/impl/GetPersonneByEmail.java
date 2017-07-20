package fr.norsys.filrouge.dao.personne.impl;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import fr.norsys.filrouge.entities.Personne;

public class GetPersonneByEmail extends ApersonneTest{

	@Test
	public void shouldGetPersonneByMail() {
		
		Personne personneGiven=this.personneDao.getPersonneByEmail("ooudli@norsys.fr").get();
			
		assertThat(personneGiven).isNotNull();
		
	}

}
