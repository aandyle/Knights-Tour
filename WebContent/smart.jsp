<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.prog32758.*" %>
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
	<title>Knights Tour - Intelligent</title>
</head>
<body>
	
	<!-- run program -->
	<%
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	int cycles = Integer.parseInt(request.getParameter("cycles"));

	// generate grid with values
	for(int k = 0; k < cycles; k ++){
		BoardIntelligent b = new BoardIntelligent(x,y);
		while (b.isCanMove()) {
			b.recordMove(b.moves());
		}
		b.printBoard(k, "smart");
		
		b.setMoveCount(b.getMoveCount() - 1);	//initial mv and zero base adjust
		out.println("<div class='container'>");
			out.println("<div>");
				out.println("<h2 class='text-center display-2'> Attempt Number " + k + "</h2>");
				out.println("<p class='text-center'>" + b.getMoveCount() + " moves completed." + "</p>");
			out.println("</div>");
			
			out.println("<table class='table table-bordered'");
			for(int j = 0; j < 8; j++){
				out.print("<tr>");
				for(int i = 0; i < 8; i ++){
					if(b.printMove(j,i) == 64) {
						out.println("<td class='bg-success'>");
							out.println(b.printMove(j, i));
						out.println("</td>");
					} else if(b.printMove(j,i) == b.getMoveCount()){
						out.println("<td class='bg-danger'>");
							out.println(b.printMove(j, i));
						out.println("</td>");
					} else if(i%2 == j%2){
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
	}
	%>
	
</body>
</html>