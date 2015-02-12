<%
	if(session.getAttribute("userid")==null){
		response.sendRedirect("login.jsp");
	}
	else if(session.getAttribute("role").equals("user")){
		response.sendRedirect("userhome.jsp");
	}
	else{
	%>
	<%@ page import="com.ilp.fq.beans.*"%>
<!DOCTYPE html >
<html >
<head>

<title>Fast Quote Insurance | Employee Home</title>
<link href="css/imageslider.css" rel="stylesheet" type="text/css" />
<link href="css/bodycss.css" rel="stylesheet" type="text/css" />
<script src="js/imageslider.js" type="text/javascript"></script>

</head>

<body>

<div id="header">
	&nbsp;<img  src="images/fastqlogo.png" />
    <span id="caption">OK! Start Now<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I Want The Best Deal In...</span>
  <div id="usersettings">Welcome <%=session.getAttribute("userid") %> | Edit Profile | Change Password | <a href="logout.jsp">Sign out</a></div>
 
  <div id="menu">  <div class="menu">
        <ul>
            <li><a href="./emphome.jsp"><span>Home</span></a></li>
	     <li><a href="./aboutus.html"><span>About Us</span></a></li>
        </ul>
        <br style="clear: left">
    </div>
    </div>
</div>

<div id="bodymask">
<div id="fullbody" style="text-align:center;padding-top:40%;">
<h1>UNDER CONStRUCTION</h1>

</div>
<div id="footer" ><span ><img src="images/tcslogo.png" /></span><p style="text-align:center;
font-size:11px;color:#FFF">&copy; 2014 TCS | HYD20-H88 G7</p></div>

</div>
</body></html><%}%>