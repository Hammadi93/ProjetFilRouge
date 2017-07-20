package fr.norsys.filrouge.service.competition;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.filrouge.dao.CompetitionDao;
import fr.norsys.filrouge.service.CompetitionService;
import fr.norsys.filrouge.service.impl.CompetitionServiceImp;

public class ACompetitionServiceTest {
	protected CompetitionService	competitionService;

	@Mock
	protected CompetitionDao		mockCompetitionDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.competitionService = new CompetitionServiceImp(this.mockCompetitionDAO);
	}

}
