package com.cgi.open.easyshare.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cgi.open.ServicesMapper;
import com.cgi.open.easyshare.EasyShareServices;
import com.cgi.open.easyshare.InvalidPromotionException;
import com.cgi.open.easyshare.PresentAsSameUserTypeException;
import com.cgi.open.easyshare.UserNotFoundException;
import com.cgi.open.easyshare.model.Session;
import com.cgi.open.easyshare.model.UserType;

/**
 * Servlet implementation class GetAllSessions
 */
public class GetAllSessions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllSessions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MyHttpServletRequest myRequest = new MyHttpServletRequest(request);
		ServiceResponse sr = new ServiceResponse();
		sr.initServiceResponse(myRequest, "GetAllSessions");
		EasyShareServices easyshare = ServicesMapper
				.getEasyShareServicesProxyInstance();
		Set<Session> sessions = null;

		sessions = easyshare.getAllSessions();
		try {
			sr.setCode("SUCCESS");
			sr.setMessage("SUCCESS");
			sr.setData(sessions);
		} catch (Exception e) {
			sr.setCode("FAILURE");
			sr.setMessage(e.getMessage());
		}

		RenderResponse r = new RenderResponse();
		r.render(response, sr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
