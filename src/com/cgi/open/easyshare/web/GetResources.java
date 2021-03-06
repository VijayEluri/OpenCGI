package com.cgi.open.easyshare.web;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cgi.open.ServicesMapper;
import com.cgi.open.easyshare.EasyShareServices;
import com.cgi.open.easyshare.SessionNotFoundException;
import com.cgi.open.easyshare.model.Message;
import com.cgi.open.easyshare.model.Resource;

/**
 * Servlet implementation class GetResources
 */
public class GetResources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetResources() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyHttpServletRequest myRequest = new MyHttpServletRequest(request);
		ServiceResponse sr = new ServiceResponse();
		sr.initServiceResponse(myRequest, "GetResources");
		EasyShareServices easyshare = ServicesMapper
				.getEasyShareServicesProxyInstance();
		Integer sessionId=Integer.valueOf(myRequest.getParameter(REQUEST_PARAMETERS.SESSION_ID));
		Set<Resource> resources=null;		
		try {
			resources= easyshare.getResources(sessionId);
			sr.setCode("SUCCESS");
			sr.setMessage("SUCCESS");
			sr.setData(resources);
		} catch (SessionNotFoundException e) {
			sr.setCode("FAILURE");
			sr.setMessage(e.getMessage());
		}

		RenderResponse r = new RenderResponse();
		r.render(response, sr);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
