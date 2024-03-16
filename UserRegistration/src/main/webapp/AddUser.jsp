<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
 
 <%
			ArrayList<String> errList=(ArrayList<String>)request.getAttribute("validationErrors");
			if(errList!=null)
			{	
		    	Iterator itr=errList.iterator();
		   		 out.println("<font color='red'>");
		    	out.println("<ul>");		    
		    	while(itr.hasNext())
		    	{
		    	String m=(String)itr.next();
		    	out.println("<li>"+m+"</li>");
		    	}
		    	out.println("</ul>");
		    	out.println("</font>");
		    	errList.clear();
			 }	
		%>

   
 <form action="AddUserServlet" method="post">
 <table>
       <tr>
       		<td> Name:</td>
        	<td><input type="text" id="name" name="name" value="${empty user ? '' : user.name}"><br></td>
       </tr>
       <tr>
        	<td>Email:</td>
        	<td><input type="email" id="email" name="email" value="${empty user ? '' : user.email}"><br></td>
		</tr>
		<tr>
        	<td>Phone:</td>
        	<td><input type="text" id="phone" name="phone" value="${empty user ? '' : user.phone}"><br></td>
		</tr>
		<tr>
        	<td>Date of Birth:</td>
        	<td><input type="date" id="dob" name="dob" value="${empty user ? '' : user.dob}"><br></td>
		</tr>
		<tr>
        	<td>Subscribe to newsletter:</td>
        	<td><input type="checkbox" id="subscribed" name="subscribed" ${empty user ? '' : (user.subscribed ? 'checked' : '')}><br></td>
		</tr>
		<tr>
          <td>Gender:</td>
          <td>
          		<input type="radio" id="male" name="gender" value="Male" ${empty user ? '' : (user.gender == 'Male' ? 'checked' : '')}>Male
       			<input type="radio" id="female" name="gender" value="Female" ${empty user ? '' : (user.gender == 'Female' ? 'checked' : '')}>Female<br>
       	  </td>
		</tr>
		<tr>
        	<td>Country:</td>
        	<td><select id="country" name="country">
            	<option value="USA" ${empty user ? '' : (user.country == 'USA' ? 'selected' : '')}>USA</option>
            	<option value="Canada" ${empty user ? '' : (user.country == 'Canada' ? 'selected' : '')}>Canada</option>
            	<option value="UK" ${empty user ? '' : (user.country == 'UK' ? 'selected' : '')}>UK</option>
            <!-- Add more options as needed -->
        	</select><br>
        	</td>
		</tr>
		<tr>
        	<td><input type="submit" value="Add User"></td>
        </tr>
      </table>
    </form>
</body>
</html>