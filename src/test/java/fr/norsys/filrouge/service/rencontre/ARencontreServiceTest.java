package fr.norsys.filrouge.service.rencontre;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.filrouge.dao.RencontreDao;
import fr.norsys.filrouge.service.RencontreService;
import fr.norsys.filrouge.service.impl.RencontreServiceImp;

public class ARencontreServiceTest {
	protected RencontreService	rencontreService;

	@Mock
	protected RencontreDao		mockRencontreDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.rencontreService = new RencontreServiceImp(this.mockRencontreDAO);
	}

}
