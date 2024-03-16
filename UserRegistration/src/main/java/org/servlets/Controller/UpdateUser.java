package org.servlets.Controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.servlets.Dao.UserDao;
import org.servlets.Model.User;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		 String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        String dob = request.getParameter("dob");
	        boolean subscribed = request.getParameter("subscribed") != null;
	        String gender = request.getParameter("gender");
	        String country = request.getParameter("country");

	        // Create User object
	        User user = new User();
	        user.setId(userId);
	        user.setName(name);
	        user.setEmail(email);
	        user.setPhone(phone);
	        user.setDob(dob);
	        user.setSubscribed(subscribed);
	        user.setGender(gender);
	        user.setCountry(country);
	        UserDao.updateUser(user);
	        response.sendRedirect(request.getContextPath() + "/ViewAllServlet");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
