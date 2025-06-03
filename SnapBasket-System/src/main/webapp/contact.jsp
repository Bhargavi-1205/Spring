<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<html>
<body>
<h2> This is Contact Page</h2>
<form action="Register" method="post">
<div>
   <label for="name">Name :</label>
   <input type="text" id="name" name="userName" />
</div>

<div>
   <label for="email">Email :</label>
   <input type="text" id="email" name="email" />
</div>

<div>
   <label for="phno">Phone Number :</label>
   <input type="number" id="phno" name="phoneNumber" />
</div>

 <input type ="submit">
</form>

</body>
</html>