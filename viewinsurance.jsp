<%
	if(session.getAttribute("userid")==null){
		response.sendRedirect("login.jsp");
	}
	else{
%>
<%@ page import="java.util.Vector" %>
<%@ page import="com.ilp.fq.beans.*" %>
<!DOCTYPE html >
<html >
<head>

<title>Fast Quote Insurance | View Insurances</title>
<link href="css/imageslider.css" rel="stylesheet" type="text/css" />
<link href="css/bodycss.css" rel="stylesheet" type="text/css" />
<script src="js/imageslider.js" type="text/javascript"></script>

<style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width:0px;
	border-color: #666666;
	border-collapse: collapse;
	width:90%;
	
}
table.gridtable th {
	border-width:1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color:#0CF;
}
table.gridtable td {
		border-width:0px;
	padding: 8px;
	background-color: #ffffff;
}
#icon { 
  opacity: 0.3; 
} 

#icon:hover { 
  opacity: 1; 
}
td{
	text-align:center;
}
</style>

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
    </div>    </div>
</div>

<div id="bodymask">
<div id="mainbody">
	<table class="gridtable" >
    <tr style="background-color:#09F;">
    	<th>Insurance ID</th>
        <th>Type</th>
        <th>Vehicle ID</th>
        <th>Coverage</th>
        <th>Duration</th>
        <th>Start Date</th>
        <th>Premium</th>
      </tr>
      <%Vector<InsuranceBean> insurances=(Vector<InsuranceBean>)session.getAttribute("insuranceslist");
  		int i=insurances.size();
  		for(int j=0;j<i;j++){
  			InsuranceBean b=(InsuranceBean)insurances.get(j);
  		
  		%>
      <tr>
      <td><%=b.getInsuranceid() %></td>
      <td><%=b.getTypeofinsurance() %></td>
      <td><%=b.getVehicleid() %></td>
      <td><%=b.getCoverage() %></td>
      <td><%=b.getNoofmonths() %></td>
      <td><%=b.getStartdate() %></td>
      <td><%=b.getPremium() %> /-</td>
      <td><a onclick="return confirm('ARE YOU SURE YOU WANT TO EDIT THIS INSURANCE?');" href="UpdateInsuranceServlet?id=<%=b.getInsuranceid() %>"><img id="icon" src="images/edit.png" /></a></td>
      <td><a onclick="return confirm('ARE YOU SURE YOU WANT TO DELETE THIS INSURANCE?');" href="DeleteInsuranceServlet?id=<%=b.getInsuranceid() %>"><img id="icon" src="images/del.png" /></a></td>
      </tr>
      <%} %>
      
      </table>
      
      
      
        
</div>
<div id="rightbar">
	
    
    
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