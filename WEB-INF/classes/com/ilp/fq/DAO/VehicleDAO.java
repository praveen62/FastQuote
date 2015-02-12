package com.ilp.fq.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import com.ilp.fq.beans.VehicleBean;
import com.ilp.fq.utilities.DBConnector;

public class VehicleDAO {

	
	
	public boolean addVehicle(VehicleBean vehiclebean) throws Exception{
		Connection con=null;
		
		try {
			con=DBConnector.getConnection();
		
			String userid= vehiclebean.getUserid();
			String make = vehiclebean.getMake();
			String model = vehiclebean.getModel();
			int yom = vehiclebean.getYearofManufacture();
			String type = vehiclebean.getType();
			int orp = vehiclebean.getRoadPrice();
		
		    Statement statement=con.createStatement();
		    statement.executeUpdate("insert into Vehicle_868 (vehicleid,userid,make,model,year_of_manufacture,type,roadprice) values(vehicle_seq.NEXTVAL,'"+userid+"','"+make+"','"+model+"',"+yom+",'"+type+"',"+orp+")");
		
		    return true;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
				
			DBConnector.close(con);
				
		}
		return false;
	
	}
	
	public boolean updateVehicle(VehicleBean vehiclebean) throws Exception{
		Connection con=null;
		
		try {
			con=DBConnector.getConnection();
		
			
			
			String userid= vehiclebean.getUserid();
			String make = vehiclebean.getMake();
			String model = vehiclebean.getModel();
			int yom = vehiclebean.getYearofManufacture();
			String type = vehiclebean.getType();
			int orp = vehiclebean.getRoadPrice();
			String vehicleid=""+vehiclebean.getVehicleid();
			
		    Statement statement=con.createStatement();
		    statement.executeUpdate("update Vehicle_868 set make='"+make+"' , model='"+model+"' , year_of_manufacture="+yom+" , type='"+type+"' , roadprice="+orp+"  where vehicleid="+vehicleid+" AND userid='"+userid+"'");
		    
		    return true;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
				
			DBConnector.close(con);
				
		}
		return false;
	
	}
	
	public Vector<VehicleBean> getVehicles(String userid) throws Exception{
		Vector<VehicleBean> vehicles=new Vector<VehicleBean>();
		Connection con=null;
		
		try {
			con=DBConnector.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery("select * from Vehicle_868 where userid='"+userid+"'");
			
			while(rs.next()){
		
				VehicleBean b= new VehicleBean();
				b.setMake(rs.getString(2));
				b.setModel(rs.getString(3));
				b.setYearofManufacture(Integer.parseInt(rs.getString(4)));
				b.setType(rs.getString(5));
				b.setRoadPrice(Integer.parseInt(rs.getString(6)));
				b.setVehicleid(Integer.parseInt(rs.getString(7)));
				vehicles.add(b);
			}
			return vehicles;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
				
			DBConnector.close(con);
				
		}
		return vehicles;
	}
	public boolean deleteVehicle(String vehicleid,String userid) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		
		try {
			con=DBConnector.getConnection();
			Statement statement=con.createStatement();
			int a=statement.executeUpdate("delete from Vehicle_868 where vehicleid="+vehicleid+" AND userid='"+userid+"'");
			if(a==0){
				return false;
			}
			else
				return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
				
			DBConnector.close(con);
				
		}
		return false;
	}
	public VehicleBean getVehiclebyId(String vehicleid,String userid) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		VehicleBean b=null;
		try {
			con=DBConnector.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery("select * from Vehicle_868 where vehicleid="+vehicleid+" AND userid='"+userid+"'");
			
			while(rs.next()){
		
				b= new VehicleBean();
				b.setUserid(userid);
				b.setMake(rs.getString(2));
				b.setModel(rs.getString(3));
				b.setYearofManufacture(Integer.parseInt(rs.getString(4)));
				b.setType(rs.getString(5));
				b.setRoadPrice(Integer.parseInt(rs.getString(6)));
				b.setVehicleid(Integer.parseInt(rs.getString(7)));
				return b;
			}
			return b;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
				
			DBConnector.close(con);
				
		}
		return b;
	}
}
