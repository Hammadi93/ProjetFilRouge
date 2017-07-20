package fr.norsys.filrouge.dao.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;

public class GetPronosticsByPersonneTest extends APronosticTest {
	
	protected List<Pronostic> listPronosticByPersonne=new ArrayList<>();

	@Test
	public void shouldGetPronosticByPersonne() {
		
		Personne personneGiven=this.personneDao.getPersonneById(1).get();
		
		listPronosticByPersonne=this.pronosticDao.getPronosticsByPersonne(personneGiven);
		
		assertThat(this.listPronosticByPersonne.stream().count()).isEqualTo(3);
	}

}
