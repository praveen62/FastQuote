package com.ilp.fq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.fq.DAO.UserDAO;
import com.ilp.fq.beans.UserBean;

/**
 * Servlet implementation class UserRegisterServlet
 */
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean userbean = new UserBean();
		userbean.setUname(request.getParameter("userid"));
		userbean.setName(request.getParameter("name"));
		userbean.setGender(request.getParameter("gender"));
		userbean.setMailId(request.getParameter("email"));
		userbean.setLicenceStatus(request.getParameter("status"));
		String ssn=request.getParameter("ssn1")+request.getParameter("ssn2")+request.getParameter("ssn3");
		userbean.setSsn(ssn);
		userbean.setAnnualIncome(Integer.parseInt(request.getParameter("income")));
		userbean.setOccupation(request.getParameter("occupation"));
		userbean.setDob(request.getParameter("dob"));
		userbean.setEducation(request.getParameter("education"));
		userbean.setAge(Integer.parseInt(request.getParameter("age")));
		System.out.print(userbean.getUname()+userbean.getName()+userbean.getGender()+userbean.getMailId()+userbean.getLicenceStatus()+userbean.getSsn()+userbean.getAnnualIncome()+userbean.getDob()+userbean.getOccupation()+userbean.getAge()+userbean.getEducation());
		UserDAO userdao=new UserDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try{
			if(userdao.registerUser(userbean))
				out.print("<h1>Successfully Registered</h1><br/>Your User ID is: "+userbean.getUname()+"<br/>Your DEfault Password is: "+userbean.getPwd()+"<br/><a href='./login.jsp' >Click here to goto login page</a>");
			else
				out.print("FAIL");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
