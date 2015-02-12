package com.ilp.fq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddVehicle
 */

import javax.servlet.http.HttpSession;

import com.ilp.fq.DAO.*;
import com.ilp.fq.beans.VehicleBean;

public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    public AddVehicle() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VehicleDAO vehicleDAO=new VehicleDAO();
		HttpSession session=request.getSession();
		VehicleBean vehiclebean=new VehicleBean();
		vehiclebean.setUserid((String)session.getAttribute("userid"));
		vehiclebean.setMake(request.getParameter("make"));
		vehiclebean.setModel(request.getParameter("model"));
		vehiclebean.setType(request.getParameter("type"));
		vehiclebean.setYearofManufacture(Integer.parseInt(request.getParameter("yom")));
		vehiclebean.setRoadPrice(Integer.parseInt(request.getParameter("orp")));
		System.out.println(vehiclebean.getMake()+vehiclebean.getModel()+vehiclebean.getRoadPrice()+vehiclebean.getType()+vehiclebean.getYearofManufacture()+vehiclebean.getUserid());
		PrintWriter out=response.getWriter();
		try
		{
			if(vehicleDAO.addVehicle(vehiclebean)){
				out.print("<script> alert('VEHICLE REGISTERED SUCCESSFULLY!!!');window.location='ViewVehicleServlet';</script>");
			}
			else
				out.print("<script>alert('UNABLE TO REGISTER VEHICLE..Try Again Later!!');</script>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
