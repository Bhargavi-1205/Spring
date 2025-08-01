<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>


<html>
<head>
<title>Passport Page </title>
</head>


<body>
</body>
<form action="save" method="post">
<p>
   <label for = "passportOffice">Passport Office :</label>
   <input type ="text" id="passportOffice" name="passportOffice" value="${item.passportOffice}" />
 </p>
<p>
   <label for = "givenName">Customer Name :</label>
   <input type ="text" id="givenName" name="givenName" value="${item.givenName}" />
 </p>
 <p>
    <label for = "surName">SurName :</label>
    <input type ="text" id="surName" name="surName"  value="${item.surName}"/>
  </p>
  <p>
     <label for = "date">Date of Birth :</label>
     <input type ="date" id="date" name="dob" value="${item.dob}" />
   </p>
   <p>
      <label for = "email">Customer Email :</label>
      <input type ="email" id="email" name="email" value="${item.email}" />
    </p>
    <p>
          <label for = "loginId">Login Id :</label>
          <input type ="number" id="loginId" name="loginId" value="${item.loginId}" />
        </p>
     <p>
              <label for = "password">Password :</label>
              <input type ="text" id="password" name="Password" value="${item.password}" />
     </p>
          <p>
                   <label for = "confirmPassword">Confirm Password :</label>
                   <input type ="text" id="confirmPassword" name="confirmPassword" value="${item.confirmPassword}" />
          </p>
          <p>
                <label for = "hintAnswer">Hint Answer :</label>
                 <input type ="text" id="hintAnswer" name="HintAnswer" value="${item.hintQuestion}" />
          </p>
          <p>
                     <label for = "hintQuestion">Hint Question :</label>
                     <input type ="text" id="hintQuestion" name="HintQuestion" value="${item.hintAnswer}"/>
           </p>
    <input type ="submit">

 </form>
</html>