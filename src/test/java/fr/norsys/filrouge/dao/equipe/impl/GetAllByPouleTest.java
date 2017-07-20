package fr.norsys.filrouge.dao.equipe.impl;




import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import fr.norsys.filrouge.entities.Equipe;
import fr.norsys.filrouge.entities.Poule;


public class GetAllByPouleTest extends AEquipeTest {

	protected List<Equipe> lstEquipesByPoule;
	
	@Test
	public void shouldGetAllByPoule() {
		
		Poule poule=this.pouleDao.getPoulleById(2).get();
		
		this.lstEquipesByPoule = this.equipeDao.getAllByPoulle(poule);
		
		assertThat(this.lstEquipesByPoule).isNotNull();

	}

}
