<%
	if(session.getAttribute("userid")==null){
		
		if(session.getAttribute("role").equals("employee")){
			response.sendRedirect("emphome.jsp");
		}
		else if(session.getAttribute("role").equals("user")){
			response.sendRedirect("userhome.jsp");
		}
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
<script type="text/javascript">

function validate(myform)
{

	userid=myform.userid.value;
	name=myform.name.value;
	dob=myform.dob.value;
	email=myform.email.value;
	status=myform.status.value;
	age=myform.age.value;
	ssn1=myform.ssn1.value;
	income=myform.income.value;
	occupation=myform.occupation.value;
	education=myform.education.value;
	var x=email;
	var atpos=x.indexOf("@");
	var dotpos=x.lastIndexOf(".");
	
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	  {
	  alert("Not a valid e-mail address");
	  return false;
	  }
	 
	if(userid.length>20){
		alert('User id should not exceed 20 characters!!');
		return false;
		}
	if(name.length>30){
		alert('Name should not exceed 30 characters!!');
		return false;
	
		}
	if(occupation.length>30){
		alert('Occupation should not exceed 30 characters!!');
		return false;
	
		}
	if(email.length>40){
		alert('Email Id should not exceed 40 characters!!');
		return false;
	
		}
	var genderradio = myform.gender;
	var gender1;
	for(var i = 0; i < genderradio.length; i++){
	    if(genderradio[i].checked){
	        gender1 = genderradio[i].value;
	    }
	}
	
	var pattern1=/^[a-zA-Z\ ]+$/;
	if(userid==null||userid==""){
		alert('Username cannot be Empty!!');
		return false;
	}
	var datepatt = /^\d{4}-\d{1,2}-\d{1,2}$/;
	pat=/\s+/g;
   	if(pat.test(userid)){
   	   		alert('No white spaces allowed for userid!!');
   	   		return false;	  
	}
	if (!name.match(pattern1)||(name==null || name==""))
	  {
	  alert("Enter a valid Name");
	  return false;
	  }
	
	
	
	
	if(!(genderradio[0].checked || genderradio[1].checked )){
		alert("Please select gender!!");
		return false;
	}
	
	if(!datepatt.test(dob)){
		alert("invalid date format");
		return false;
		}
	
	if(age<18){
		alert("Please check date of birth..age must be greater than 18!!");
		return false;
		}
	
	if(status=="")
	{
	  alert("Enter the license status");
	  return false;
	}
	
	var patt3=/^[0-9]+$/ ;
	if( ssn1.length!=9 || (ssn1==null || ssn1=="" || !ssn1.match(patt3)) ){
	  alert("Enter valid SSN number!!!");
	  return false;
	}
	
	if(!income.match(patt3)||pat.test(income)){
			alert('Provide valid income details!!!');
			return false;
		}
	if(income<10000 || income>9999999)
	{
		 alert("Range of income is 10001-10000000!!");
		  return false;
	}
	if(occupation==null || occupation==""){
			alert('Please provide Occupation!!');
			return false;
		}
	if(!pattern1.test(occupation))
	{
		 alert("Occupation should contain Only characters!!");
		  return false;
	}
	if(education=="")
	{
	  alert("Select Education!!");
	  return false;
	}
	return true;


}

function calculateage (myform) {
	dob=myform.dob.value;
	d1=new Date(dob);
	d2 = new Date();
	var diff = d2.getTime() - d1.getTime();
	age1= Math.floor(diff / (1000 * 60 * 60 * 24 * 365.25));
	myform.age.value=age1;
}

</script>

<script>
function createRequestObject() {
    var tmpXmlHttpObject;
    
   
    if (window.XMLHttpRequest) { 
        
        tmpXmlHttpObject = new XMLHttpRequest();
	
    } else if (window.ActiveXObject) { 
     
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    return tmpXmlHttpObject;
}


var http = createRequestObject();

function loginCheck(f) {
	
   	username=f.username.value;
   	password=f.password.value;
 
    http.open('get', 'LoginCheckServlet?username='+username+'&password='+password);
	
   
    http.onreadystatechange = processResponse;
    http.send(null);
}

function processResponse() {
    
    if(http.readyState == 4){
	
        
        var response = http.responseText;
		if(response=="user"){
			window.location="userhome.jsp";
		} 
		else if(response=="employee"){
			window.location="emphome.jsp";
		}
		else if(response=="inactive"){
			document.getElementById('check').innerHTML = "*This Account is Inactive";
		}
		else if(response=="error"){
			document.getElementById('check').innerHTML = "*Incorrect username or password";	
		}
		else
        	document.getElementById('check').innerHTML = "*Something gone wrong\n Please try again later";
		
        
    }
}
</script>


</head>

<body>

<div id="header">
	&nbsp;<img  src="images/fastqlogo.png" />
    <span id="caption">OK! Start Now<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I Want The Best Deal In...</span>
  
 
  <div id="menu">  <div class="menu">
        <ul>
            <li><a href="./login.jsp"><span>Home</span></a></li>
           	<li><a href=""><span>Policies</span></a></li>
           	
	     	<li><a href="./aboutus.html"><span>About Us</span></a></li>
        </ul>
        <br style="clear: left">
    </div>
    </div>
</div>

<div id="bodymask">
<div id="mainbody">

<form name="myform" onsubmit="return validate(this);" action="EditprofileServlet" method="post">
<center>
<table style="width:600px" cellspacing="30">
<caption><h2><b>REGISTER</b> </h2></caption>

<tr>
<td>
<%UserBean userbean=(UserBean)session.getAttribute("userdetails"); %>
<table style="width:600px">
<tr>

<td><input type="hidden" id="textbox" name="userid" size="30" placeholder=" Username" value="<%=userbean.getUname()%>"/></td>
</tr>
<tr>
<td>Name<span style="color:red;"> *</span></td><td>:</td>
<td><input type="text" id="textbox" name="name" size="30"  placeholder=" Name" value="<%=userbean.getName()%>"/></td>
</tr>

<tr>
<td >Gender<span style="color:red;"> *</span></td><td>:</td>
<td>
<% 
String test;
String gen=userbean.getGender();
if( gen.equals("MALE")){%>
	 <input type="radio" name="gender" id="1" value="MALE" checked="true"/ >Male
	 <input type="radio" name="gender" id="2" value="FEMALE" / >Female <%} %>
	<% if( gen.equals("FEMALE")){%>
	<input type="radio" name="gender" id="1" value="MALE" / >Male
	 <input type="radio" name="gender" id="2" value="FEMALE" checked="true"/ >Female<%} %></td>
</tr>

<tr>
<td>Date of Birth<span style="color:red;"> *</span></td><td>:</td>
<td><input type="date" id="dropbox" style="height:30px;" placeholder="yyyy-mm-dd" name="dob" onblur="calculateage(this.form)" value="<%=userbean.getDob() %>"/> </td>
</tr>


<tr>
<td >E-Mail<span style="color:red;"> *</span></td><td>:</td>
<td><input type="text" id="textbox" name="email"  placeholder=" E-mail" size="30" value="<%=userbean.getMailId() %>" ></td>
</tr>

<tr>
<td >Current license status<span style="color:red;"> *</span></td><td>:</td>
<td>
<select name="status" id="dropbox">
<option value="<%=userbean.getLicenceStatus() %>"><%=userbean.getLicenceStatus() %></option>
<option value="active">active</option>
<option value="inactive">inactive</option>
<option value="suspended">suspended</option>
<option value="revoked">revoked</option>
</select>
</tr>

<tr>
<td>Age<span style="color:red;"> *</span></td><td>:</td>
<td><input type="text" id="textbox" name="age" placeholder=" Age"  size="30" value="<%= userbean.getAge()%>" onchange="calculateage(this.form)" /></td>
</tr>

<tr>
<td >SSN<span style="color:red;"> *</span></td><td>:</td>
<td ><input type="text" id="textbox" name="ssn1" size="30"   value="<%= userbean.getSsn()%>"  ></td>
</tr>

<tr>
<td >Annual Income<span style="color:red;"> *</span></td><td>:</td>
<td><input type="text" placeholder=" Annual Income" id="textbox" name="income" size="30" value="<%=userbean.getAnnualIncome() %>" ></td>
</tr>

<tr>
<td> Occupation<span style="color:red;"> *</span></td><td>:</td>
<td><input type="text" id="textbox" name="occupation" placeholder=" Occupation" size="30" value="<%=userbean.getOccupation() %>"/> 
</tr>

<tr>
<td >Highest level of education<span style="color:red;"> *</span></td><td>:</td>
<td><select name="education" id="dropbox">
<option value="<%=userbean.getEducation() %>"><%=userbean.getEducation() %></option>
<option value="Less than High School">Less than High School</option>
<option value="High School">High School</option>
<option value="High School, pursuing College Degree">High School, pursuing College Degree</option>
<option value="Bachelors">Bachelors</option>
<option value="Bachelors, pursuing Masters Degree">Bachelors, pursuing Masters Degree</option>
<option value="Masters">Masters</option>
<option value="PhD">PhD</option>
</select></td>
</tr>




</table>
</td>
</tr>

</table>

<input type="submit" id="button1"  />
<input type="button" id="button1" onclick="window.location='./userhome.jsp'" value="Cancel"/>
<br/>
<br/>
</center>
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
font-size:11px;color:#FFF">&copy; 2014 TCS | HYD20-H88 Group: 2</p></div>

</div>
</body></html>
<%}%>