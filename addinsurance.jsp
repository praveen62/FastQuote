<%
	if(session.getAttribute("userid")==null){
		response.sendRedirect("login.jsp");
	}
	else{
	%>
	<%@ page import="com.ilp.fq.beans.*"%>
	<%@ page import="java.text.*"%>
<!DOCTYPE html >
<html >
<head>

<title>Fast Quote Insurance | Register Insurance</title>
<link href="css/imageslider.css" rel="stylesheet" type="text/css" />
<link href="css/bodycss.css" rel="stylesheet" type="text/css" />
<script src="js/imageslider.js" type="text/javascript"></script>
<script type="text/javascript">

function check_option(val)
{
	 
	 if(val == "vehicle-damage" || val == "liability")
	 {
		 document.input.vehicleid.disabled = false;
		 
	 }
	 else
	 {
		 document.input.vehicleid.disabled = true;
		 document.input.vehicleid.value="";
	 }
} 
function validateForm1()
{
	 if (document.forms["input"]["typeofinsurance"].value==0)
	   {
		
		 alert("Type of insurance must be filled out");
		 return false;
	   }

	
	
	 if(document.forms["input"]["typeofinsurance"].value=="vehicle-damage"||document.forms["input"]["typeofinsurance"].value=="liability")
	 {
		var a=document.forms["input"]["vehicleid"].value;
	 if (a==null || a=="")
	   {
		 
	   alert("Vehicle id must be filled out");
	   return false;
	   }
	 if(isNaN(a))
	 	{	
		
		 alert("Only numeric values are allowed for vehicle identification number");
		 return false;
	 	}
	 
	 }
	
	
	
	 
	 var b=document.forms["input"]["coverage"].value;

	 if (b==null || b=="")
	   {
	  alert("coverage amount must be filled out");
	  
	   return false;
	   }
	 if(isNaN(b) || !(/^\+?[1-9]\d*$/.test(b)))
	 {
	 
	 alert("Only numeric values are allowed for coverage amount");
	 return false;
	 }

	 
	 
	 var c=document.forms["input"]["noofmonths"].value;

	 if (c==null || c=="")
	   {
	   alert("no of months must be filled out");
	   return false;
	   }
	 if(isNaN(c)|| !(/^\+?[1-9]\d*$/.test(c)))
	 {
		
	 alert("Only numeric values are allowed for no of months");
	 return false;
	 }
	 var d=document.forms["input"]["startdate"].value;
	// alert(d);
	 if (d=null || d=="")
	   {
	   alert("startdate must be filled out");
	   return false;
	   }
	 
	
    
	
var r=confirm("Are you sure you want to submit?");
if (r==true)
  {
  x="You pressed OK!";
  }
else
  {
  x="You pressed Cancel!";
return false;
  }
		

}

function validateForm2()
{
	

	 
var y;
var s=confirm("Are you sure you want to reset?");
if (s==true)
  {
  y="You pressed OK!";
  }
else
  {
  y="You pressed Cancel!";
return false;
  }
}

</script>
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
</div></div>
<div id="bodymask">
<div id="mainbody">


<form name="input" action="AddInsuranceServlet" method="post"  onsubmit="return validateForm1()" onreset="return validateForm2()" >

<table cellspacing="50px">

<tr><td>
Type of Insurance</td><td>:</td><td><select id="dropbox" name="typeofinsurance" onchange="check_option(this.value)">
<option value="0">Choose Your Option</option>
<option value="Body-injury">Body-injury coverage</option>
<option value="vehicle-damage">vehicle-damage coverage</option>
<option value="liability">liability coverage</option>
</select></td></tr>
<tr><td>Vehicle id</td><td>:</td><td><input type="text" id="textbox" name="vehicleid" disabled="disabled" ></input></td></tr>
<tr><td>Coverage amount</td><td>:</td><td><input type="text" id="textbox" name="coverage"></td></tr>
<tr><td>Duration</td><td>:</td><td><input type="text" name="noofmonths" id="textbox"  ></td></tr>
<tr><td>Start Date</td><td>:</td><td><input type="date" placeholder="yyyy-mm-dd" id="textbox" name="startdate" ></td></tr>
<tr  style="text-align:center;" ><td><input type="submit" value="Submit"  id="button1" ></td><td/>
<td><button  type="reset" id="button1" >Reset</button></td></tr>
</table>

</form>


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