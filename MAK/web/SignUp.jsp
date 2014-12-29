<%-- 
    Document   : SignUp
    Created on : Dec 20, 2014, 3:33:05 PM
    Author     : Sho3la
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <title>FCI Research Sign up</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />         
        <script>
            function validate()
        {
              var name = document.forms["f"]["name"].value;
              var email = document.forms["f"]["email"].value;
              var password = document.forms["f"]["password"].value;
              if(name == "" || email == "" || password == "")
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
        <form name ="f" method="post" onsubmit = "return validate()" action="SignUpAuthentication"  class="login">
	
	<p>
      <label for="login">Name:</label>
      <input type="text" name="name" id="name">
    </p>
	
	<p>
      <label for="login">User name:</label>
      <input type="text" name="uName" id="uName">
    </p>
	
	<p>
      <label for="login">Email:</label>
      <input type="text" name="email" id="email" value="name@example.com">
    </p>
	
	<p>
      <label for="login">Age:</label>
      <input type="text" name="age" id="age" >
    </p>
	
	<p>
      <label for="login">Job:</label>
      <input type="text" name="job" id="job" >
    </p>
	
    <p>
      <label for="password">Password:</label>
      <input type="password" name="password" id="password">
    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>
	
	<p>
	<h1> <b>Select Tags: </b></h1>
	<input type="checkbox" name="tags" value="History"> History
	<input type="checkbox" name="tags" value="Computer Science"> Computer Science 
	<input type="checkbox" name="tags" value="Sport"> Sport<br>
	<input type="checkbox" name="tags" value="Engineering"> Engineering
	<input type="checkbox" name="tags" value="Social Media"> Social Media
	</p>
        

  </form>
  
<section class="about">
    
    <p class="about-author">
      © 2014–2015 <a href="https://www.facebook.com/Sho3laaa" target="_blank">Khaled</a>
<a href="https://www.facebook.com/Ahmed.justyou" target="_blank">Ahmed Kamal</a>
<a href="https://www.facebook.com/Programmer.A7mD.MakRaM.22.s3oOoDy.74" target="_blank">ِAhmed Makram</a>
  </p></section>


</body>
</html>
