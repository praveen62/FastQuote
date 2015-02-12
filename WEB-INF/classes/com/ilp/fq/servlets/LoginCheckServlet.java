package com.ilp.fq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ilp.fq.DAO.*;
/**
 * Servlet implementation class LoginCheckServlet
 */
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginCheckServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username= request.getParameter("username");
		String password=request.getParameter("password");
		UserDAO userDAO=new UserDAO();
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		try {
			if(userDAO.checkCredentials(username, password)){
				if(userDAO.getStatus().equals("active")){
					HttpSession session=request.getSession();
					session.setAttribute("userid",username);
					String role=userDAO.getRole();
					session.setAttribute("role", role);
					
					if(role.equals("user")){
						session.setAttribute("userdetails", userDAO.getUserDetails(username));
						out.print("user");
					}
					else
						out.print("employee");
				}
				else
					out.print("inactive");
			}
			else
				out.print("error");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
