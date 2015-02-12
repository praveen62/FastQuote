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

public class AddInsuranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddInsuranceServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		InsuranceBean b=new InsuranceBean();
		b.setCoverage(Integer.parseInt(request.getParameter("coverage")));
		b.setNoofmonths(Integer.parseInt(request.getParameter("noofmonths")));
		b.setStartdate(""+request.getParameter("startdate"));
		b.setTypeofinsurance(request.getParameter("typeofinsurance"));
		if(!b.getTypeofinsurance().equals("Body-injury")){
			b.setVehicleid(Integer.parseInt(request.getParameter("vehicleid")));
		}
		InsuranceDAO dao=new InsuranceDAO();
		try {
			
			if(dao.addInsurance(b,""+session.getAttribute("userid")))
			{
				out.println("<script>alert('Insurance Registered Successfully'); window.location='ViewInsuranceServlet';</script>");
			}
			else
				out.println("<script>alert('Insurance Not Registered'); window.location='ViewInsuranceServlet';</script>");
		}  catch (Exception e) {
					// TODO Auto-generated catch block
			out.println("<script>alert('Insurance Not Registered'); window.location='ViewInsuranceServlet';</script>");
					e.printStackTrace();
		}
				
	}
			
			
}
		
	


