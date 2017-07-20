package fr.norsys.filrouge.service.personne;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.filrouge.dao.PersonneDao;
import fr.norsys.filrouge.service.PersonneService;
import fr.norsys.filrouge.service.impl.PersonneServiceImp;

public class APersonneServiceTest {
	protected PersonneService	personneService;

	@Mock
	protected PersonneDao		mockPersonneDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.personneService = new PersonneServiceImp(this.mockPersonneDAO);
	}

}
