package fr.norsys.filrouge.web.controller;

import static org.mockito.Mockito.mock;

import java.security.Principal;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.norsys.filrouge.controllers.RencontreController;
import fr.norsys.filrouge.service.RencontreService;
import fr.norsys.filrouge.service.impl.RencontreServiceImp;

public class ARencontreControllerTest {
	protected RencontreController	rencontreController;

	/**
	 * on mock la model
	 */
	@Mock
	protected Model					mockModel;
	/**
	 * on mock la RencontreService
	 */
	@Mock
	protected RencontreService		rencongtreService;
	/**
	 * on mock RencontreServiceImp
	 */
	@Mock
	protected RencontreServiceImp	mockRencontreService;
	/**
	 * on mock redirectAttributes
	 */
	@Mock
	protected RedirectAttributes	redirectAttributes;
	/**
	 * on mock HttpServletRequest
	 */
	@Mock
	protected HttpServletRequest	mockHttpServletRequest;
	/**
	 * on mock HttpServletResponse
	 */
	@Mock
	protected HttpServletResponse	mockHttpServletResponse;
	/**
	 * on mock la ServletOutputStream
	 */
	@Mock
	protected ServletOutputStream	mockServletOutputStream;
	/**
	 * on mock Session
	 */
	@Mock
	protected HttpSession			mockSession;
	/**
	 * on mock Principal
	 */
	@Mock
	protected Principal				mockPrincipal;

	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws Exception {
		mockSession = mock(HttpSession.class);
		this.rencontreController = new RencontreController();
		MockitoAnnotations.initMocks(this);

		// MockHelper.mockField(this.rencontreController, "rencontreService",
		// this.mockRencontreService);
	}
}
