package fr.norsys.filrouge.service.rencontre;

import org.junit.Test;

import fr.norsys.filrouge.entities.Rencontre;

public class DeleteRencontreTest extends ARencontreServiceTest {

	@Test
	public void shoudDeleteRencontre() {
		Rencontre rencontre = new Rencontre();
		rencontre.setIdRencontre(1);

		this.rencontreService.deleteRencontre(rencontre.getIdRencontre());
	}

}
