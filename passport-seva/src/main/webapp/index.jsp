<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<html>
<body>
<h2>Pasport Seva!</h2>
<a href="getAllPassportApplication">Click here to get all passport application</a>
<a href="getNameById">Find Application By Id: </a>
<form action="save" method="post">
<p>
   <label for = "passportOffice">Passport Office :</label>
   <input type ="text" id="passportOffice" name="passportOffice" />
 </p>
<p>
   <label for = "givenName">Customer Name :</label>
   <input type ="text" id="givenName" name="givenName" />
 </p>
 <p>
    <label for = "surName">SurName :</label>
    <input type ="text" id="surName" name="surName" />
  </p>
  <p>
     <label for = "date">Date of Birth :</label>
     <input type ="date" id="date" name="dob" />
   </p>
   <p>
      <label for = "email">Customer Email :</label>
      <input type ="email" id="email" name="email" />
    </p>
    <p>
          <label for = "loginId">Login Id :</label>
          <input type ="number" id="loginId" name="loginId" />
        </p>
     <p>
              <label for = "password">Password :</label>
              <input type ="text" id="password" name="Password" />
     </p>
          <p>
                   <label for = "confirmPassword">Confirm Password :</label>
                   <input type ="text" id="confirmPassword" name="confirmPassword" />
          </p>
          <p>
                <label for = "hintAnswer">Hint Answer :</label>
                 <input type ="text" id="hintAnswer" name="HintAnswer" />
          </p>
          <p>
                     <label for = "hintQuestion">Hint Question :</label>
                     <input type ="text" id="hintQuestion" name="HintQuestion" />
           </p>
    <input type ="submit">

 </form>
</body>
</html>
