package fr.norsys.filrouge.service.pronostic;

import org.junit.Test;

import fr.norsys.filrouge.entities.Pronostic;

public class DeletePronosticServiceTest extends APronosticServiceTest {

	@Test
	public void shoudDeletePronostic() {
		Pronostic pronostic = new Pronostic();
		pronostic.setIdPronostic(1);

		this.pronosticService.deletePronostic(pronostic.getIdPronostic());
	}
}
