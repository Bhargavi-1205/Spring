<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<html>
<body>
<h2> This is Submit Page</h2>
<form action="Submit" method="post">
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

<div>
   <label for="address">Address :</label>
   <input type="text" id="address" name="address" />
</div>

<div>
   <label for="dob">Date of Birth :</label>
   <input type="date" id="dob" name="dob" />
</div>

<div>
   <label for="gender">Gender :</label>
   <input type="text" id="gender" name="gender" />
</div>

<div>
   <label for="qualification">Qualification :</label>
   <input type="text" id="qualification" name="qualification" />
</div>

<div>
   <label for="experience">Experience (years) :</label>
   <input type="number" id="experience" name="experience" />
</div>

<div>
   <label for="skills">Skills :</label>
   <input type="text" id="skills" name="skills" />
</div>
<div>
   <label for="hobbies">Hobbies :</label>
   <input type="text" id="hobbies" name="hobbies" />
</div>
 <input type ="submit">
</form>
</body>
</html>