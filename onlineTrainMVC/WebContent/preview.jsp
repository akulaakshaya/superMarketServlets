<%@ page import="com.google.gson.Gson" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import=" java.io.IOException,java.sql.CallableStatement, java.sql.Connection,java.sql.DriverManager,java.sql.Types,javax.servlet.RequestDispatcher,javax.servlet.ServletException,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,java.util.ArrayList,onlineTrainMVC.passengerModel,onlineTrainMVC.ticketModel,onlineTrainMVC.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Travel details</h2>
<table border = "1">

<%
ticketModel tm1=(ticketModel)request.getAttribute("ticket");
ArrayList<passengerModel> al=(ArrayList<passengerModel>)request.getAttribute("passengersList");
ArrayList<Double> ifs=(ArrayList<Double> )request.getAttribute("individualFar");
%>
<%
Gson gson = new Gson();
String ticketJson =  gson.toJson(tm1);
String passengersJson = gson.toJson(al);
System.out.println("Preview.jsp:"+ticketJson);
//String s="sjsdjd";
%>


<tr><td><b>source</b></td><td><%=tm1.getFrom()%></td></tr>
<tr><td>destination</td><td><%=tm1.getTo() %></td></tr>

<tr><td>train number</td><td><%=tm1.getTno() %></td></tr>
<tr><td>class</td><td><%= tm1.getTr_class()%></td></tr>
<tr><td>date</td><td><%=tm1.getDate() %></td></tr>
<tr><td>fare</td><td><%=tm1.getTotalFare() %></td></tr>

</table>
<h2>Passengers</h2>

<table border = "1">
<tr><td>NAME</td><td>AGE</td><td>GENDER</td><td>fare</td></tr>
<tr><td><%=al.get(0).getName() %></td><td><%=al.get(0).getAge()%></td><td><%=al.get(0).getGender() %></td><td><%=ifs.get(0) %></td></tr>
<tr><td><%=al.get(1).getName() %></td><td><%=al.get(1).getAge() %></td><td><%=al.get(1).getGender() %></td><td><%=ifs.get(1) %></td></tr>
<tr><td><%=al.get(2).getName() %></td><td><%=al.get(2).getAge() %></td><td><%=al.get(2).getGender()%></td><td><%=ifs.get(2) %></td></tr>
<tr><td><%=al.get(3).getName() %></td><td><%=al.get(3).getAge() %></td><td><%=al.get(3).getGender()%></td><td><%=ifs.get(3) %></td></tr>
<tr><td><%=al.get(4).getName() %></td><td><%=al.get(4).getAge() %></td><td><%=al.get(4).getGender() %></td><td><%=ifs.get(4) %></td></tr>
</table>
<br>
<button onclick="window.history.back()">edit</button>

<script type="text/javascript">
function finalS(){
	document.getElementById("x").value='<%=ticketJson %>';
	document.getElementById("y").value='<%=passengersJson  %>';
	document.getElementById("xyz").submit();
	}
</script>


<form method="POST" action="finalServlet" id="xyz">

<input type="hidden" id="x" name="ticketJson" value="1">
<input type="hidden" id="y" name="passengersJson" value="2">

<input type="button" value="BOOK" onclick="finalS()" ></form>
</body>

</html>