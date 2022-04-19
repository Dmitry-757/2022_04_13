<%@ page import="java.util.ArrayList" %>
<%@ page import="org.dng.Car" %><%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 20.04.2022
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    ArrayList<Car> cars = (ArrayList<Car>) request.getAttribute("cars");
%>
<table>
    <tr>
        <th>gosNom</th>
        <th>power</th>
        <th>issueYear</th>
    </tr>
    <% for (Car car : cars){ %>
        <tr>
            <td
                    <%= car.getGosNom() %>
                    <%= car.getPower() %>
                    <%= car.getIssueYear() %>
            </td>
        </tr>
    <%}%>
</table>
</body>
</html>
