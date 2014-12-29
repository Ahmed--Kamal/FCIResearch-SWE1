<%-- 
    Document   : index
    Created on : Dec 20, 2014, 3:29:52 PM
    Author     : Sho3la
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <title>FCI Research Login</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script>
            function validateLogin()
            {
              var name = document.forms["f1"]["email"].value;
              var email = document.forms["f1"]["password"].value;
              if(email == "" || password == "")
              {
                    alert("Fill missing info");
                    //<meta http-equiv="refresh" content="0; url=index.jsp" />
                    return false;
              }
              return true;
            }
        </script>
    </head>
    <body>
  <form name ="f1" method="post" onsubmit = "return validateLogin()" action="LoginAuthentication" class="login">
    <p>
      <label for="login">Email:</label>
      
      <input type="text" name="email" id="login" value="name@example.com">
    </p>

    <p>
      <label for="password">Password:</label>
      <input type="password" name="password" id="password" value="4815162342">
    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>

    <p class="forgot-password"><a href="SignUp.jsp">Sign up</a></p>
  </form>

<section class="about">
    
    <p class="about-author">
      © 2014–2015 <a href="https://www.facebook.com/Sho3laaa" target="_blank">Khaled</a>
<a href="https://www.facebook.com/Ahmed.justyou" target="_blank">Ahmed Kamal</a>
<a href="https://www.facebook.com/Programmer.A7mD.MakRaM.22.s3oOoDy.74" target="_blank">ِAhmed Makram</a>
  </p></section>


</body>
</html>

