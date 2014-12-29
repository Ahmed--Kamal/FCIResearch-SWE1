<%-- 
    Document   : Notification
    Created on : Dec 26, 2014, 4:26:34 PM
    Author     : Sho3la
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Models.FCIDB"%>
<%@page import="Models.ResearcherInfo"%>
<%@page import="Controllers.LoginAuthentication"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Notification</title>

	<link rel="shortcut icon" href="img/gt_favicon.png">
	
	<!-- Bootstrap -->
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.no-icons.min.css" rel="stylesheet">
	<!-- Icons -->
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	<!-- Fonts -->
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Alice|Open+Sans:400,300,700">
	<!-- Custom styles -->
	<link rel="stylesheet" type="text/css" href="css/homeStyles.css">

	<!--[if lt IE 9]> <script src="assets/js/html5shiv.js"></script> <![endif]-->
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <style>
table, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 15px;
    background-color: gray;
    color: white;
}
table, th{
    font-weight: bold;
    text-align: center;
    color: cyan;
}
</style>
</head>
<body
    
    <%
        session = request.getSession();
        String emm = "";
        emm = (String) session.getAttribute("email");
        String userr = "";
        FCIDB dbb = new FCIDB();
        dbb.statement = dbb.connection.prepareStatement("select * from researchers ");
        ResultSet rss = dbb.statement.executeQuery();
        while (rss.next())
        {
            if(emm.equals(rss.getString(3))){
                userr = rss.getString(1);
                break;
            }
        }
    %>
    
    class="home">

<header id="header">
	<div id="head" class="parallax" parallax-speed="2">
		<h1 id="logo" class="text-center">
			<img class="img-circle" src="img/guy.jpg" alt="">
			<span class="title"><%= userr %></span>
			<span class="tagline">User Mail<br>
				<a href=""><%= String.valueOf(emm)%></a></span>
		</h1>
	</div>

	<nav class="navbar navbar-default navbar-sticky">
		<div class="container-fluid">
			
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
			</div>
			
			<div class="navbar-collapse collapse">
				
				<ul class="nav navbar-nav">
					<li class="active"><a href="Notification.jsp">Notifications</a></li>
					<li><a href="Home.jsp">About</a></li>
                                        <li><a href="JoinGroup.jsp">Join Groups</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">More Pages <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="Group.jsp">Create Group</a></li>
							<li><a href="Research.jsp">Add Research</a></li>
							<li><a href="Search.jsp">Search</a></li>
						</ul>
					</li>
					<li><a href="index.jsp">Log-Out</a></li>
				</ul>
			
			</div><!--/.nav-collapse -->			
		</div>	
	</nav>
    
    
</header>
<%
    session = request.getSession();
    String em = "";
    em = (String) session.getAttribute("email");
    FCIDB db = new FCIDB();
    db.statement = db.connection.prepareStatement("select * from group_request ");
    ResultSet rs = db.statement.executeQuery();
    ArrayList<String> group = new ArrayList<String>();
    ArrayList<String> mails = new ArrayList<String>();
    while (rs.next()){
        if(em.equals(rs.getString(1)))
        {
            group.add(rs.getString(3));
            mails.add(rs.getString(2));
        }
    }
    //out.println("Groups: ");
    //out.println( String.valueOf( gr ));
%>
<form name ="f2" method="post" action="NotificationAuthentication" class="login">
	
    <p>
    <table  style="width:100%">
        
        <tr>
            <th><b>Group Name</b></th>
            <th>Request Owner</th>
        </tr>
        <tr>
        <% for(int i=0; i<group.size(); i++){ %>
            <td> <%= group.get(i) %></td>
            <td> <%= mails.get(i) %> </td>
        </tr>
        <%}%>
    </table>
    </p>
    <p>
    <br><br>
    <input type="text" name = "gName" placeholder="Group Name" id="name">
    </p>
    <p>
    <br><br>
    <input type="text" name = "mail" placeholder="Request Owner mail" id="name">
    </p>
    <p>
      <button type="submit" class="login-button">Login</button>
    </p>

  </form>
    <section class="about">
  
    <p class="about-author">
      © 2014–2015 <a href="https://www.facebook.com/Sho3laaa" target="_blank">Khaled</a>
<a href="https://www.facebook.com/Ahmed.justyou" target="_blank">Ahmed Kamal</a>
<a href="https://www.facebook.com/Programmer.A7mD.MakRaM.22.s3oOoDy.74" target="_blank">ِAhmed Makram</a>
  </p></section>
<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="assets/js/template.js"></script>
</body></html>