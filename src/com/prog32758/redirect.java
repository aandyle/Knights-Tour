package com.prog32758;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public redirect() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		RequestDispatcher rd = request.getRequestDispatcher("random.jsp");
		
		if("dumb".equals(mode)) {
			rd.forward(request, response);
		} else {
			response.sendRedirect("smart.jsp");
		}
		
	}

}
