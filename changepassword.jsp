<%
	if(session.getAttribute("userid")==null){
		
		if(session.getAttribute("role").equals("employee")){
			response.sendRedirect("login.jsp");
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

function validatepwd(myform)
{
	var un=myform.oldpwd.value;
	var pd=myform.pwd.value;
	var pd1=myform.pwd1.value;
	
 
 var password = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,10}$/; 
  if((un==null || un==""))
  {
  alert("Enter old password");
  return false;
  }
  else if((pd==null || pd==""))
  {
  alert("Enter new password");
  return false;
  }
  else if((pd1==null || pd1==""))
  {
  alert("Re-enter new password");
  return false;
  }
 
  else if(!pd1.match(pd))
  {
   alert("Entered password and re-entered password doesnot match");
   return false;
  }
  else if(!pd.match(pd1))
  {
   alert("Entered password and re-entered password doesnot match");
   return false;
  }
  else if ((pd.length < 6) || (pd.length > 10))
  {
  alert("Your Password must be 6 to 10 Characters");
  return false;
  }
  else if(!pd.match(password))
  {
	  alert("Password should contain atleast one upper case,one lowercase,one spl char and one number");
	  return false;
  }
  
}
 


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
<center>
<form name="myform" action="Passwordmanagement" onsubmit="return validatepwd(this)" method="post">
  <table style="width:600px"  cellspacing="30">
  <tr>
      <td>Old password:</td>
   
         <td><input type="password" id="textbox" name="oldpwd" /></input></td>
         <tr>
         	<td>New Password:</td>
        <td><input type="password" id="textbox" name="pwd"/></input></td></tr>
    
  <tr>
   <td>Confirm New Password:</td>
   <td><input type="password" id="textbox" name="pwd1"/></td>
  </tr>
   </table>
  
  <input type="submit" value="Change" id="button1" ></input>
  <input type="button" id="button1" onclick="window.location='./userhome.jsp'" value="Cancel"/>
  </form>
  </center>
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