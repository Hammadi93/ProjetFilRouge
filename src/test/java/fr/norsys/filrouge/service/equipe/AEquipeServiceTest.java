package fr.norsys.filrouge.service.equipe;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.filrouge.dao.EquipeDao;
import fr.norsys.filrouge.service.EquipeService;
import fr.norsys.filrouge.service.impl.EquipeServiceImp;

public class AEquipeServiceTest {
	protected EquipeService	equipeService;

	@Mock
	protected EquipeDao		mockEquipeDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.equipeService = new EquipeServiceImp(this.mockEquipeDAO);
	}

}
