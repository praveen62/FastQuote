<%
	if(session.getAttribute("userid")==null){
		response.sendRedirect("login.jsp");
	}
	else{
	%>

<%@ page import="com.ilp.fq.beans.*"%>
<!DOCTYPE html >
<html >
<head>

<title>Fast Quote Insurance | User Home</title>
<link href="css/imageslider.css" rel="stylesheet" type="text/css" />
<link href="css/bodycss.css" rel="stylesheet" type="text/css" />
<script src="js/imageslider.js" type="text/javascript"></script>

</head>

<body>

<div id="header">
	&nbsp;<img  src="images/fastqlogo.png" />
    <span id="caption">OK! Start Now<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I Want The Best Deal In...</span>
  <div id="usersettings">Welcome <%=session.getAttribute("userid") %> | <a href="editprofile.jsp">Edit Profile</a> | <a href="changepassword.jsp">Change Password</a> | <a href="logout.jsp">Sign out</a></div>
 
  <div id="menu">  <div class="menu">
        <ul>
            <li><a href="./userhome.jsp"><span>Home</span></a></li>
            <li><a href=""><span>Life Insurance</span></a>
            <ul class="sub-menu">
	            <li>
        	        <a href="addinsurance.jsp">Add Insurance</a>
            		</li>
            		<li>
	                <a href="./ViewInsuranceServlet">View Insurances</a>
        		    </li>
	        </ul>
            </li>
            <li><a href=""><span>Auto Insurance</span></a>
			<ul class="sub-menu">
	            <li>
        	        <a href="addvehicle.jsp">Add Vehicle</a>
            		</li>
            		<li>
	                <a href="./ViewVehicleServlet">View Vechicles</a>
        		    </li>
	        </ul>
		</li>
	     <li><a href="./aboutus.html"><span>About Us</span></a></li>
        </ul>
        <br style="clear: left">
    </div>
    </div>
</div>

<div id="bodymask">
<div id="mainbody">

<div id="sliderFrame" >
        <div id="slider" style="width:100%;">
           
            <img src="images/image0.jpg" alt="Welcome to FAST QUOTES" />
            <img src="images/image1.jpg" alt="INSURE YOUR LIFE" />
            <img src="images/image2.jpg" alt="PROTECT YOUR FAMILY" />
            <img src="images/image3.jpg" alt="" />
            <img src="images/image4.jpg" />
        </div>
        
    </div>
    <br/>
	<p><b>Fast Quotes</b> is a professional insurance agency, servicing lawyers, real estate and mortgage brokers, bankers, commercial and residential customers in the metropolitan area for over 20 years. With more than fifty five companies, we offer current products and competitive programs. We look forward to servicing your business.
</p><p>
Protecting yourself and your family from the unexpected takes planning and the right insurance policies. If you're looking for great insurance coverage at affordable prices, you're in the right place.</p>


</div>
<div id="rightbar">
	<div id="rightbarbox">
    <h2>Profile:</h2>
    <%UserBean userbean=(UserBean)session.getAttribute("userdetails"); %>
    <table style="color:#5F5F5F;width:190" cellspacing="5px">
    	<tr>
        	<td>Name</td><td>:</td>
            <td><%=userbean.getName() %></td>
         </tr>
         <tr>
         	<td>Gender</td><td>:</td>
            <td><%=userbean.getGender() %></td>
         </tr>
         <tr>
         	<td>Date Of Birth</td><td>:</td>
            <td><%=userbean.getDob() %></td>
         </tr> 
         <tr>
         	<td>License Status</td><td>:</td>
            <td><%=userbean.getLicenceStatus() %> </td>
         </tr>
         <tr>
         	<td>Occupation</td><td>:</td>
            <td><%=userbean.getOccupation() %></td>
            </tr>
       </table>
     
    
    </div>
    
    
    <div id="rightbarboxlast">
    <h2>Our Coverage:</h2>
   	<img src="images/vehicle.png" />
    <br/>
    <img src="images/personal.png" />
    </div>
    
    
</div>


<div id="footer" ><span ><img src="images/tcslogo.png" /></span><p style="text-align:center;
font-size:11px;color:#FFF">&copy; 2014 TCS | HYD20-H88 G7</p></div>

</div>
</body></html>
<%}%>