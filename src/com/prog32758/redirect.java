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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		String mode = request.getParameter("mode");
		
		if("dumb".equals(mode)) {
			rd = request.getRequestDispatcher("random.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("smart.jsp?x=" + request.getParameter("x") + "&y=" 				//sendRedirect doesn't pass parameters???????
					+ request.getParameter("y") + "&cycles=" + request.getParameter("cycles"));
		}
	}

}
