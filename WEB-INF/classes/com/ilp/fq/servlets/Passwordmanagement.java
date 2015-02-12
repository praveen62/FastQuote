package com.ilp.fq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ilp.fq.DAO.UserDAO;
import com.ilp.fq.beans.UserBean;


public class Passwordmanagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Passwordmanagement() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in doGet()...");
		UserDAO UserDAO=new UserDAO();
		UserBean ub=new UserBean();
		String old=request.getParameter("oldpwd");
		String pwd=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		try {
			int res=UserDAO.changepd(pwd,old,""+session.getAttribute("userid"));
			if(res==1){
			   
			   out.println("<script> alert('Password updated successfully!!!!!');window.location='userhome.jsp'</script>");
			   ub.setPwd(pwd);
			}
			else
				out.println("<script> alert('Please provide valid password!!!!!');window.location='changepassword.jsp'</script>");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
