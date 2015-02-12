package com.ilp.fq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ilp.fq.DAO.UserDAO;
import com.ilp.fq.beans.UserBean;


public class EditprofileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditprofileServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBean userbean = new UserBean();
		userbean.setUname(request.getParameter("userid"));
		userbean.setName(request.getParameter("name"));
		userbean.setGender(request.getParameter("gender"));
		userbean.setMailId(request.getParameter("email"));
		userbean.setLicenceStatus(request.getParameter("status"));
		String ssn=request.getParameter("ssn1");
		userbean.setSsn(ssn);
		userbean.setAnnualIncome(Integer.parseInt(request.getParameter("income")));
		userbean.setOccupation(request.getParameter("occupation"));
		userbean.setDob(request.getParameter("dob"));
		userbean.setEducation(request.getParameter("education"));
		System.out.println(request.getParameter("education"));
		userbean.setAge(Integer.parseInt(request.getParameter("age")));
		System.out.print(userbean.getUname()+userbean.getName()+userbean.getGender()+userbean.getMailId()+userbean.getLicenceStatus()+userbean.getSsn()+userbean.getAnnualIncome()+userbean.getDob()+userbean.getOccupation()+userbean.getAge()+userbean.getEducation());
		UserDAO userdao=new UserDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try{
			HttpSession session=request.getSession();
			session.setAttribute("userdetails",userbean);
			if(userdao.editUser(userbean))
				out.print("<script> alert('Updated successfully!!!!!');window.location='userhome.jsp'</script>");
			else
				out.print("FAIL");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
