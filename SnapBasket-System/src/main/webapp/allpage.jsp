<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
<title>Snapbasket Application</title>
</head>
<body>
<p>Thankyou for Registering</p>
<table border="1px">
<tr>
    <th>userName</th>
    <th>email</th>
    <th>phoneNumber</th>
    <th>Action</th>
 </tr>

          <c:forEach var="item" items ="${listOfDto}">
          <tr>
          <td>${item.userName}</td>
          <td>${item.email}</td>
          <td>${item.phoneNumber}</td>
          <td><a href="getNameById?id=${item.id}">view</a>
          <a href ="updateById?id=${item.id}">update</a></td>
          </tr>
          </c:forEach>
           </table>
           </body>
 </html>