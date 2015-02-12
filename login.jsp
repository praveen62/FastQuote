<%@ page session="true" %>
<%
if(session.getAttribute("userid")!=null){
	if(session.getAttribute("role").equals("user")){
		response.sendRedirect("userhome.jsp");
	}
	else if(session.getAttribute("role").equals("employee")){
		response.sendRedirect("emphome.jsp");
	}
	}
	else{
	%>
<!DOCTYPE html >
<html >
<head>
<title>Fast Quote Insurance | Login</title>
<link href="css/imageslider.css" rel="stylesheet" type="text/css" />
<link href="css/bodycss.css" rel="stylesheet" type="text/css" />
<script src="js/imageslider.js" type="text/javascript"> </script>

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
	 <form name=myForm>
    <h2>Sign In</h2>
   
    <table style="color:black;width:100%;" cellspacing="5px">
    	<tr>
        	<td>Username</td>
         </tr>
         <tr><td><input id="textbox" type="text" placeholder="  Username" name="username"></input></td></tr>
         <tr>
         	<td>Password</td>
         </tr>
         <tr><td><input id="textbox" type="password" placeholder="  Password" name="password"></input></td></tr>
    </table>
    <br/>
     <div style="text-align:center;">
     	<input type="button" id="button1" onclick="loginCheck(this.form);" value="Sign In" autofocus/>
     	<br/>
     	<br/>
     	<div style="color:red;" id=check></div>
     </form>
     </div>
    	
    </div>
    <div id="rightbarbox">
    <h2>New User?</h2>
    <table style="color:#5F5F5F" cellspacing="5px">
    	<div style="text-align:center;">
    		<input type="button" id="button1" onclick="window.location='./userregister.jsp'" value="Create Account"/>
    	</div>
    	
    </table>
     
    
    </div>
    
    <div id="rightbarboxlast">
    <h2>Our Coverage</h2>
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