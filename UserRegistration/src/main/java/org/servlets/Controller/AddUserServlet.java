package org.servlets.Controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.servlets.Dao.UserDao;
import org.servlets.Model.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Extract user input
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        boolean subscribed = request.getParameter("subscribed") != null;
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");

        // Create User object
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setDob(dob);
        user.setSubscribed(subscribed);
        user.setGender(gender);
        user.setCountry(country);
     // Validate input
        List<String> validationErrors = validateUserInput(name, email, phone, dob);

        if (!validationErrors.isEmpty()) {
            // Set validation errors as request attribute
            request.setAttribute("validationErrors", validationErrors);
            System.out.println("Error exists");
            Iterator itr=validationErrors.iterator();
            while(itr.hasNext())
	    	{
            	String m=(String)itr.next();
            	System.out.print(m);
	    	}
            request.setAttribute("user", user);
            // Forward to the index page
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddUser.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
       

        // Insert user into the database
        UserDao.addUser(user);

        // Redirect to the index page
        response.sendRedirect("index.jsp");
		
	}
	
	 private List<String> validateUserInput(String name, String email, String phone, String dob) {
	        List<String> errors = new ArrayList<>();

	        // Validation logic (add your validation rules)
	        if (name == null || name.trim().isEmpty()) {
	            errors.add("Name is required.");
	        }

	        if (email == null || !isValidEmail(email)) {
	            errors.add("Invalid email address.");
	        }

	        if (phone == null || !isValidPhone(phone)) {
	            errors.add("Invalid phone number.");
	        }

	        if (dob == null || !isValidDate(dob)) {
	            errors.add("Invalid date of birth.");
	        }

	        return errors;
	    }

	    private boolean isValidEmail(String email) {
	        // Email validation logic (add your validation rules)
	        // For simplicity, using a basic pattern matching here
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	        Pattern pattern = Pattern.compile(emailRegex);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }

	    private boolean isValidPhone(String phone) {
	        // Phone number validation logic (add your validation rules)
	        // For simplicity, using a basic pattern matching here
	        String phoneRegex = "^\\d{10}$";
	        Pattern pattern = Pattern.compile(phoneRegex);
	        Matcher matcher = pattern.matcher(phone);
	        return matcher.matches();
	    }

	    private boolean isValidDate(String date) {
	        // Date validation logic (add your validation rules)
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            sdf.setLenient(false);
	            Date parsedDate = sdf.parse(date);
	            return parsedDate != null;
	        } catch (ParseException e) {
	            return false;
	        }
	    }

}
