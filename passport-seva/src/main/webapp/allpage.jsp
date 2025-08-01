<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
<title>Passport Application</title>
</head>
<body>
<p>Thankyou for Registering</p>
<table border="1px">
<tr>
    <th>passportOffice</th>
    <th>givenName</th>
    <th>surName</th>
    <th>date</th>
    <th>email</th>
    <th>loginId</th>
    <th>password</th>
    <th>confirmPassword</th>
    <th>hintQuestion</th>
    <th>hintAnswer</th>
    <th>Action</th>
 </tr>

          <c:forEach var="item" items ="${listOfDto}">
          <tr>
          <td>${item.passportOffice}</td>
          <td>${item.givenName}</td>
          <td>${item.surName}</td>
          <td>${item.dob}</td>
          <td>${item.email}</td>
          <td>${item.loginId}</td>
          <td>${item.password}</td>
          <td>${item.confirmPassword}</td>
          <td>${item.hintQuestion}</td>
          <td>${item.hintAnswer}</td>
          <td><a href="getNameById?id=${item.id}">view</a>
         <a href ="updateById?id=${item.id}">update</a>
         <a href ="delete?id=${item.id}">delete</a></td>
          </tr>
          </c:forEach>
           </table>
           </body>
 </html>