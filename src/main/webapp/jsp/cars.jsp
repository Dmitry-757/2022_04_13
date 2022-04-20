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
    <style>
        table {
            border-collapse: collapse;
            border: 2px solid rgb(200,200,200);
            letter-spacing: 1px;
            font-size: 0.8rem;
        }

        td, th {
            border: 1px solid rgb(190,190,190);
            padding: 10px 20px;
        }
        th {
            background-color: rgb(235,235,235);
        }
        td {
            text-align: center;
        }
        /*tr:nth-child(even) td {*/
        /*    background-color: rgb(250,250,250);*/
        /*}*/

        /*tr:nth-child(odd) td {*/
        /*    background-color: rgb(245,245,245);*/
        /*}*/
    </style>
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
<%--    <tr>--%>
<%--        <td>111</td>--%>
<%--        <td>111</td>--%>
<%--        <td>111</td>--%>
<%--      </tr>--%>

    <% for (Car car : cars){ %>
        <tr>
            <td> <%= car.getGosNom() %> </td>
            <td> <%= car.getPower() %> </td>
            <td> <%= car.getIssueYear() %> </td>
        </tr>
    <%}%>
</table>
</body>
</html>
