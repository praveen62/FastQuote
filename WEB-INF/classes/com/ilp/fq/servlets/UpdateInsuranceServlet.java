package com.ilp.fq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ilp.fq.DAO.InsuranceDAO;
import com.ilp.fq.beans.InsuranceBean;

/**
 * Servlet implementation class UpdateInsuranceServlet
 */
public class UpdateInsuranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInsuranceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InsuranceDAO insuranceDAO=new InsuranceDAO();
		InsuranceBean b=new InsuranceBean();
		
		response.setContentType("text/html");
		String insuranceid=request.getParameter("id");
		PrintWriter out=response.getWriter();
		
		try {
			HttpSession session=request.getSession();
			b=insuranceDAO.getInsurancebyId(insuranceid,""+session.getAttribute("userid"));
			session.setAttribute("insurancetoupdate", b);
			if(b!=null)
				response.sendRedirect("updateinsurance.jsp");
			else{
				out.print("<script> alert('Could Not Update..try Again Later!!');window.location='ViewInsuranceServlet';</script>");
			}
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
