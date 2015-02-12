<%
	if(session.getAttribute("userid")==null){
		response.sendRedirect("login.jsp");
	}
	else{
	%>
	<%@ page import="java.util.*"%>
	<%@ page import="com.ilp.fq.beans.*"%>
	<%@ page import="java.text.*"%>
	<%VehicleBean b= (VehicleBean)session.getAttribute("vehicletoupdate"); %>
<!DOCTYPE html >
<html >
<head>

<title>Fast Quote Insurance | Update Vehicle</title>
<link href="css/imageslider.css" rel="stylesheet" type="text/css" />
<link href="css/bodycss.css" rel="stylesheet" type="text/css" />
<script src="js/imageslider.js" type="text/javascript"></script>
<script type="text/javascript">


function validate(){
	var f=document.myform;
	
	if(f.make.value=="" && (f.model.value=="" || f.model.value==null) && (f.yom.value==null || f.yom.value=="") && f.type.value=="" && f.orp.value==""){
		alert("Please Fill All the Fields");
		return false;
	}
	else if(f.make.value=="")
	{
		alert("Please select the Make");
		return false;
	}
else if(f.yom.value=="" || f.yom.value==null)
{
	alert("Please select the Year");
	return false;
}
else if(f.type.value=="" || f.type.value==null)
{
	alert("Please select the Type");
	return false;
}
else if(f.orp.value=="" || f.orp.value==null)
{
	alert("Please enter the Price");
	return false;
}
	else if(!(/^\+?[1-9]\d*$/.test(f.orp.value))){
		alert("Price must be a number");
		return false;
	}
	else if(f.orp.value<10000 || f.orp.value>9999999)
	{
		 alert("Range of vehicle price is 10001-10000000!!");
		  return false;
	}
	else if(!f.agreement.checked){
		alert("Please accept license agreement");
		return false;
	}
	else{
		// alert("Vehicle Registered Successfully");
		return true;
	}
}
function changedropdown(){
	var makev=document.myform.make.value;
	var modelv=document.myform.model;
	modelv.options.length = 0;
	if (makev == "") {
  		modelv.options[modelv.options.length] = new Option('Please select Make','');
	}
	if (makev == "BMW") {
	  	modelv.options[modelv.options.length] = new
		Option('128i','128i');
  		modelv.options[modelv.options.length] = new
		Option('M3','M3');
		modelv.options[modelv.options.length] = new
		Option('M5','M5');
		modelv.options[modelv.options.length] = new
		Option('M6','M6');
		modelv.options[modelv.options.length] = new
		Option('X3','X3');
		modelv.options[modelv.options.length] = new
		Option('X5','X5');
		modelv.options[modelv.options.length] = new
		Option('X6','X6');
	}
	if (makev == "Chevrolet") {
	  	modelv.options[modelv.options.length] = new
		Option('Aveo','Aveo');
  		modelv.options[modelv.options.length] = new
		Option('Camaro','Camaro');
		modelv.options[modelv.options.length] = new
		Option('Silverado','Silverado');
		modelv.options[modelv.options.length] = new
		Option('Suburban','Suburban');
		modelv.options[modelv.options.length] = new
		Option('Traverse','Traverse');
	}
if (makev == "Ford") {
	  	modelv.options[modelv.options.length] = new
		Option('Crown Victoria','Crown Victoria');
  		modelv.options[modelv.options.length] = new
		Option('Escape','Escape');
		modelv.options[modelv.options.length] = new
		Option('Fusion','Fusion');
		modelv.options[modelv.options.length] = new
		Option('Ranger','Ranger');
		modelv.options[modelv.options.length] = new
		Option('Taurus','Taurus');
	}
	if (makev == "Honda") {
	  	modelv.options[modelv.options.length] = new
		Option('Accord','Accord');
  		modelv.options[modelv.options.length] = new
		Option('Civic','Civic');
		modelv.options[modelv.options.length] = new
		Option('Fit','Fit');
		modelv.options[modelv.options.length] = new
		Option('Pilot','Pilot');
	}
	if (makev == "Hyundai") {
	  	modelv.options[modelv.options.length] = new
		Option('Accent','Accent');
  		modelv.options[modelv.options.length] = new
		Option('Azera','Azera');
		modelv.options[modelv.options.length] = new
		Option('Elantra','Elantra');
		modelv.options[modelv.options.length] = new
		Option('Sonata','Sonata');
	}
	if (makev == "Toyota") {
	  	modelv.options[modelv.options.length] = new
		Option('Avalon','Avalon');
  		modelv.options[modelv.options.length] = new
		Option('Camry','Camry');
		modelv.options[modelv.options.length] = new
		Option('Corolla','Corolla');
		modelv.options[modelv.options.length] = new
		Option('Tundra','Tundra');
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
    </div>
</div>

<div id="bodymask">
<div id="mainbody">
<p style="color:#F00;font-size:12px;
line-height:14px;font-style:italic;">Fast Quotes offers Vehicle Shield, a comprehensive package policy which covers Loss or Damage to your car; Liability to third parties and provides personal accident cover to the Owner/Driver. Car Shield also comes with a host of discounts. <a href="">click here to read more..</a></p>

<form name="myform" action="UpdateVehicleValuesServlet" method="post" onsubmit="return validate()">
<table cellspacing="50px">
	<tr>
    <td>Make</td>
    <td>:</td>
    <td><select id="dropbox" name="make" onchange="changedropdown();">
  		<option value="">--Select--</option>
  		<%
  		
  		String[] make={"BMW","Chevrolet","Ford","Honda","Hyundai","Toyota"};
  		ArrayList<String[]> modelslist=new ArrayList<String[]>();
  		modelslist.add(0,new String[]{"128i","M3","M5","M6","X3","X5","X6"});
  		modelslist.add(1,new String[]{"Aveo","Camaro","Silverado","Suburban","Traverse"});
  		modelslist.add(2,new String[]{"Crown Victoria","Escape","Fusion","Ranger","Taurus"});
  		modelslist.add(3,new String[]{"Accord","Civic","Fit","Pilot"});
  		modelslist.add(4,new String[]{"Accent","Azera","Elantra","Sonata"});
  		modelslist.add(5,new String[]{"Avalon","Camry","Corolla","Tundra"});
		String flag="";
		String vehiclemake=b.getMake();
		String vehiclemodel=b.getModel();
		int j=0;
  		for(int i=0;i<6;i++){
  			flag="";
  			if(make[i].equals(vehiclemake)){
  				flag="selected";
  				j=i;}
  		%>
		<option value="<%=make[i]%>" <%=flag %>><%=make[i]%></option>
  		<%} %>
  		</select>
    </td>
    </tr>
	
	<tr>
    <td>Model</td>
    <td>:</td>
    <td>
    
    <select  id="dropbox" name="model" >
    <%
    
    String[] models=(String[])modelslist.get(j);
    
    for(int i=0;i<models.length;i++){
    	flag="";
    	if(models[i].equals(vehiclemodel))
    		flag="selected";
    %>
    <option value="<%=models[i]%>" <%=flag %>> <%=models[i] %></option>
    <%} %>
		</select>
    </td>
    </tr>
    
    <tr>
    <td>Year of Manufacture</td>
    <td>:</td>
    <td><select id="dropbox" name="yom">
  	<option value="">--Select--</option>
		
    <%
    int yyyy=(new java.util.Date().getYear() + 1900) ;
    for(int i=0;i<10;i++){
    	flag="";
    	if(yyyy-i==b.getYearofManufacture())
    		flag="selected";
    %>
    <option value=<%=yyyy-i %> <%=flag %>><%=yyyy-i %></option>	
    <%
    }
    %>
    </td>
    </tr>


	<tr>
    <td>Type</td>
    <td>:</td>
    <td><select id="dropbox" name="type" >
    
  		<option value="">--Select--</option>
  		<%
  		String[] type={"Coupe","Sedan","Hatchback","SUV"};
  		for(int i=0;i<type.length;i++){
  			flag="";
  			if(type[i].equals(b.getType()))
  				flag="selected";
  		%>
		<option value="<%=type[i]%>" <%=flag %>><%=type[i] %></option>
  		<%} %>
  		</select>
    </td>
    </tr>

   	<tr>
    <td>On Road Price</td>
    <td>:</td>
    <td><input type="text" id="textbox" name="orp" placeholder=" Price" value=<%=b.getRoadPrice() %> />
    </td>
    </tr>
    
	<tr><td colspan="3"><input type="checkbox"  name="agreement" > I Accept the licence Agreement</input></td></tr>

<tr style="text-align:center;"><td><input type="submit" id="button1"  value="Update"/>
</td><td/><td><input type="button" id="button1" onclick="window.location='./userhome.jsp'" value="Cancel"/></td></tr>
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