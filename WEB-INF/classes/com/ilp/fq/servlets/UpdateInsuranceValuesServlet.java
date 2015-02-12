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
 * Servlet implementation class UpdateInsuranceValuesServlet
 */
public class UpdateInsuranceValuesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInsuranceValuesServlet() {
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
		
		InsuranceDAO insuranceDAO=new InsuranceDAO();
		HttpSession session=request.getSession();
		InsuranceBean b1= (InsuranceBean)session.getAttribute("insurancetoupdate");
		InsuranceBean b=new InsuranceBean();
		b.setCoverage(Integer.parseInt(request.getParameter("coverage")));
		b.setNoofmonths(Integer.parseInt(request.getParameter("noofmonths")));
		b.setStartdate(""+request.getParameter("startdate"));
		System.out.println("askldjlaksd"+request.getParameter("typeofinsurance"));
		b.setTypeofinsurance(b1.getTypeofinsurance());
		if(!b.getTypeofinsurance().equals("Body-injury")){
			b.setVehicleid(Integer.parseInt(request.getParameter("vehicleid")));
		}
		b.setInsuranceid(((InsuranceBean)session.getAttribute("insurancetoupdate")).getInsuranceid());
		PrintWriter out=response.getWriter();
		try
		{
			if(insuranceDAO.update(b)){
				out.print("<script> alert('INSURANCE UPDATED SUCCESSFULLY!!!');window.location='ViewInsuranceServlet';</script>");
			}
			else
				out.print("<script>alert('UNABLE TO UPDATE VEHICLE..Try Again Later!!');</script>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
