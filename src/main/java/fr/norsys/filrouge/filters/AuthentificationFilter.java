package fr.norsys.filrouge.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import fr.norsys.filrouge.entities.Personne;

@WebFilter(urlPatterns = { "/classement", "/competitions", "/poulles/*", "/mesPronostic", "/pronostic/*",
		"/rencontres/*" }, filterName = "ClientFilter", description = "Filter all client URLs")
public class AuthentificationFilter implements Filter {

	final static Logger logger = Logger.getLogger(AuthentificationFilter.class);

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		logger.info(" initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		logger.info("Requested Resource::" + uri);

		HttpSession session = req.getSession();
		Personne personne = (Personne) session.getAttribute("personne");
		if (personne == null) {
			uri = uri.replace("/fillRouge", "");
			res.sendRedirect("/fillRouge/login?next=" + uri);
		} else {
			logger.info("Auth Personne::" + personne.getNomPersonne() + " " + personne.getPrenomPersonne());
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}