<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<html>
<body>
<h2> This is Login Page</h2>
<form action="SignIn" method="post">
<div>
   <label for="name">Name :</label>
   <input type="text" id="name" name="userName" />
</div>

<div>
   <label for="email">Email :</label>
   <input type="text" id="email" name="email" />
</div>

<div>
   <label for="password">Password :</label>
   <input type="text" id="pass" name="password" />
</div>
 <input type ="submit">
</form>
</body>
</html>