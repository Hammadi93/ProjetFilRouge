package fr.norsys.filrouge.service.pronostic;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.filrouge.dao.PronosticDao;
import fr.norsys.filrouge.service.PronosticService;
import fr.norsys.filrouge.service.impl.PronosticServiceImp;

public class APronosticServiceTest {
	protected PronosticService	pronosticService;

	@Mock
	protected PronosticDao		mockPronosticDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.pronosticService = new PronosticServiceImp(this.mockPronosticDAO);
	}

}
