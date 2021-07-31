<!DOCTYPE html>

<%@page import="java.sql.Date" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

</head>
<body>

	<div class="container">
		<h2>Note</h2>
		<table class="table table-striped">
			<tbody>
				<tr>
					<th>Name</th>
					<td><% String n= (String)(session.getAttribute("name")); out.print(n); %></td>
				</tr>
				<tr>
					<th>StartDate</th>
					<td><% String sd= (String)(session.getAttribute("sdate")); out.print(sd); %></td>
				</tr>
				<tr>
					<th>EndDate</th>
					<td><% String ed= (String)(session.getAttribute("edate")); out.print(ed); %></td>
				</tr>
				<tr>
					<th>RemainderDate</th>
					<td><% String rd= (String)(session.getAttribute("remDate")); out.print(rd); %></td>
				</tr>
				<tr>
					<th>Status</th>
					<td><% String s= (String)(session.getAttribute("status")); out.print(s); %></td>
				</tr>
				
				<tr>
					<th>Description</th>
					<td height="100px"><% String d= (String)(session.getAttribute("des")); out.print(d); %></td>
				</tr>
				
			</tbody>
		</table>
			<a id="noteViews" href="note">Back
												
												</a>
	</div>
    <script>
        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
        }
    </script>
</body>
</html>
