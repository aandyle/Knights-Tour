<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.prog32758.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Popper JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Knights Tour - Non-intelligent</title>
</head>
<body>

	<!-- run program -->
	<%
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int cycles = Integer.parseInt(request.getParameter("cycles"));

		String collapseHeadOpen = "<div class='card text-center'> \n <div class='card-header'> \n";
		String collapseHeadClose = "</div>";

		out.println("<div class='container'>");
		out.println("<h1 class='display text-center display-2'> Knights Tour Results </h1><br>");
		out.println("<div id='board'>");

		// generate grid with values
		for (int k = 0; k < cycles; k++) {
			Board b = new Board(x, y);
			while (b.isCanMove()) {
				b.recordMove(b.moves());
			}
			b.printBoard(k, "dumb");

			b.setMoveCount(b.getMoveCount() - 1); //initial mv and zero base adjust

			out.println(collapseHeadOpen);
			out.println("<button class='btn btn-link' data-toggle='collapse' data-target='#collapse" + k + "'>");
			out.println("<h1> Attempt Number " + k + "</h1>");
			out.println("</button>");
			out.println("<h4>" + b.getMoveCount() + " moves completed.</h4>");
			out.println(collapseHeadClose);

			if (k == 0) {
				out.println("<div id='collapse" + k + "' class='collapse show' data-parent='#board' >");
				out.println("<div class='card-body'>");
			} else {
				out.println("<div id='collapse" + k + "' class='collapse' data-parent='#board' >");
				out.println("<div class='card-body'>");
			}

			out.println("<table class='table table-bordered'");
			for (int j = 0; j < 8; j++) {
				out.print("<tr>");
				for (int i = 0; i < 8; i++) {
					if (b.printMove(j, i) == 64) {
						out.println("<td class='bg-success'>");
						out.println(b.printMove(j, i));
						out.println("</td>");
					} else if (b.printMove(j, i) == b.getMoveCount()) {
						out.println("<td class='bg-danger'>");
						out.println(b.printMove(j, i));
						out.println("</td>");
					} else if (i % 2 == j % 2) {
						out.println("<td class='bg-dark'>");
						out.println("<p class='text-light'>" + b.printMove(j, i) + "</p>");
						out.println("</td>");
					} else {
						out.println("<td>");
						out.println(b.printMove(j, i));
						out.println("</td>");
					}
				}
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");

		}
		out.println("</div></div>");
	%>

</body>
</html>