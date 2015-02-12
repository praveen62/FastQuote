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
 * Servlet implementation class UpdateVehicleValuesServlet
 */
public class UpdateVehicleValuesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicleValuesServlet() {
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
		VehicleDAO vehicleDAO=new VehicleDAO();
		HttpSession session=request.getSession();
		VehicleBean vehiclebean=new VehicleBean();
		vehiclebean.setUserid((String)session.getAttribute("userid"));
		vehiclebean.setMake(request.getParameter("make"));
		vehiclebean.setModel(request.getParameter("model"));
		vehiclebean.setType(request.getParameter("type"));
		vehiclebean.setYearofManufacture(Integer.parseInt(request.getParameter("yom")));
		vehiclebean.setRoadPrice(Integer.parseInt(request.getParameter("orp")));
		
		vehiclebean.setVehicleid(((VehicleBean)session.getAttribute("vehicletoupdate")).getVehicleid());
		System.out.println(vehiclebean.getMake()+vehiclebean.getModel()+vehiclebean.getRoadPrice()+vehiclebean.getType()+vehiclebean.getYearofManufacture()+vehiclebean.getUserid());
		PrintWriter out=response.getWriter();
		try
		{
			if(vehicleDAO.updateVehicle(vehiclebean)){
				out.print("<script> alert('VEHICLE UPDATED SUCCESSFULLY!!!');window.location='ViewVehicleServlet';</script>");
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
