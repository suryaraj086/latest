<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Customer</title>
<link rel="stylesheet" href="css/style.css">
  <script src="script/myscripts.js"></script>

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: #f2f2f2;
}
#cusform{
height:80px;
width: 500px;
margin-left: 650px;
margin-top: 115px;
}
</style>

</head>
<body>
<%	 
if (session.getAttribute("customerId") == null) {
	 response.sendRedirect(request.getContextPath() + "/login.jsp");		 
} %>
<jsp:include page="adminmenu.jsp"></jsp:include>
<form action="AddCustomer" id="cusform" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an Customer Id</p>
    <hr>
<%-- <% String id=(String)request.getParameter("id"); out.print(id);%> --%>
 <%String s=request.getParameter("id");%>
 <% if(s!=null){
	out.println("<html><body><label ><b>Id</b></label> <input type= text value="+s+ " name=id id=id disabled></body></html>");	  
	}
 %>

    <label for="name"><b>Name</b></label>
    <input type="text"  onkeypress="return isLetter()" placeholder="Enter Name" value="<%if(s!=null){out.print(request.getParameter("name"));}%>" name="name" id="name" required>
    
    <label for="age"><b>Age</b></label>
    <input type="text" onkeypress="return isNumber(event)"  placeholder="Enter Age" name="age" value="<%if(s!=null){out.print(request.getParameter("age"));} %>" id="age" required>
    
   &nbsp; <input type="radio" id="male" name="gender" value="male" required>
  <label for="deposit">male</label><br>
  <input type="radio" id="female" name="gender" value="female" required>
  <label for="withdraw">female</label>
    <br>
 
    <hr>

<input type="hidden" name="userId" value="<%out.print(s);%>">
    <button type="submit" class="registerbtn">Register</button>
    <label style="color:red;" id ="err"></label>
  </div>
</form>
</body>
</html>
