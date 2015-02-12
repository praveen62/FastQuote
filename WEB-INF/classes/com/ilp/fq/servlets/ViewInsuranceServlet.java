package com.ilp.fq.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ilp.fq.DAO.InsuranceDAO;
import com.ilp.fq.beans.InsuranceBean;

/**
 * Servlet implementation class ViewInsuranceServlet
 */
public class ViewInsuranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewInsuranceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InsuranceDAO insuranceDAO=new InsuranceDAO();
		Vector<InsuranceBean> insurances=new Vector<InsuranceBean>();
		
		try {
			HttpSession session=request.getSession();
			insurances=insuranceDAO.getInsurances(""+session.getAttribute("userid"));
			session.setAttribute("insuranceslist", insurances);
			response.sendRedirect("viewinsurance.jsp");
			
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
