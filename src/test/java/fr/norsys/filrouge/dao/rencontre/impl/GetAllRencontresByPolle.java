package fr.norsys.filrouge.dao.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import fr.norsys.filrouge.entities.Rencontre;

public class GetAllRencontresByPolle extends ARencontreTest {
	
    protected List<Rencontre> listRencontre=new ArrayList<>();
    
	@Test
	public void shouldGetAllRencontreByPolle() {
		
		this.listRencontre=this.rencontreDao.getAllRencontresByPolle(this.pouleDao.getPoulleById(1).get());
		
		assertThat(this.listRencontre.size()).isGreaterThan(0);
		
	}

}
