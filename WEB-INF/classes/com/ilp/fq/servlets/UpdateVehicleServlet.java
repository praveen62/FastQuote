package com.ilp.fq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ilp.fq.DAO.VehicleDAO;
import com.ilp.fq.beans.VehicleBean;

/**
 * Servlet implementation class UpdateVehicleServlet
 */
public class UpdateVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VehicleDAO vehicleDAO=new VehicleDAO();
		response.setContentType("text/html");
		String vehicleid=request.getParameter("id");
		PrintWriter out=response.getWriter();
		
		try {
			HttpSession session=request.getSession();
			VehicleBean b=null;
			b=vehicleDAO.getVehiclebyId(vehicleid,""+session.getAttribute("userid"));
			session.setAttribute("vehicletoupdate", b);
			if(b!=null)
				response.sendRedirect("updatevehicle.jsp");
			else{
				out.print("<script> alert('Could Not Update..try Again Later!!');window.location='ViewVehicleServlet';</script>");
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
