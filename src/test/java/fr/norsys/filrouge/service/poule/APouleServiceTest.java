package fr.norsys.filrouge.service.poule;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.filrouge.dao.PouleDao;
import fr.norsys.filrouge.service.PouleService;
import fr.norsys.filrouge.service.impl.PouleServiceImp;

public class APouleServiceTest {
	protected PouleService	pouleService;

	@Mock
	protected PouleDao		mockPouleDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.pouleService = new PouleServiceImp(this.mockPouleDAO);
	}

}
