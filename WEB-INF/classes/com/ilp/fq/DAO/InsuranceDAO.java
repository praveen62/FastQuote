package com.ilp.fq.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import com.ilp.fq.beans.InsuranceBean;
import com.ilp.fq.utilities.DBConnector;

public class InsuranceDAO {
	private int baserate;
	private double licensefactor=0.1;
	private int totalpremium=0;
	private int totalamount=0;
	private int monthlypremium=0;
	private int agefactor=0;
	
	//Calculate Premium according to details given by user
	public void calculatePremium(int coverage,int noofmonths)
	{
		totalpremium=(int) (baserate*licensefactor*agefactor);
		totalamount=coverage+totalpremium;
		monthlypremium=totalamount/noofmonths;
	}
	
	//Initializing base rate according to type of insurance selected by user
	public void setTypeofinsurance(String typeofinsurance)
	{
		
		if(typeofinsurance=="Body-injury coverage")
		{
			baserate=5000;
		}else if(typeofinsurance=="vehicle-damage coverage")
		{
			baserate=4000;
		}
		else
		{
			baserate=2000;
		}
	}
	
	//Registering new insurance into database
	public boolean addInsurance(InsuranceBean b,String userid) throws Exception
	{
		this.setTypeofinsurance(b.getTypeofinsurance());
		this.calculatePremium(b.getCoverage(), b.getNoofmonths());
		b.setPremium(monthlypremium);
		Connection con=DBConnector.getConnection();
		
		PreparedStatement ps=null;
		
		//If type of insurance is body injury then there is no need of vehicle id 
		if(b.getTypeofinsurance().equals("Body-injury")){
			ps=con.prepareStatement("insert into insurance_868 (userid,type,start_date,premiumn,coverage_amt,duration,insuranceid) values(?,?,?,?,?,?,insurance_seq.NEXTVAL)");
			ps.setString(1,userid);
			ps.setString(2, b.getTypeofinsurance());
			ps.setInt(5, b.getCoverage());
			ps.setInt(6, b.getNoofmonths());
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date1 = df.parse(b.getStartdate());
			java.sql.Date date2 = new java.sql.Date(date1.getTime());
			ps.setDate(3,date2);
			ps.setInt(4, monthlypremium);
		}
		
		else{
			ps=con.prepareStatement("insert into insurance_868 values(?,?,?,?,?,?,?,insurance_seq.NEXTVAL)");	
			ps.setString(1,userid);
			ps.setString(2, b.getTypeofinsurance());
			ps.setInt(3, b.getVehicleid());
			ps.setInt(4, b.getCoverage());
			ps.setInt(5, b.getNoofmonths());
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date1 = df.parse(b.getStartdate());
			java.sql.Date date2 = new java.sql.Date(date1.getTime());
			ps.setDate(6,date2);
			ps.setInt(7, monthlypremium);	
		}
		int a=ps.executeUpdate();
		con.close();
		if(a==0){
				return false;
		}
		else
			return true;		
	}
	
	//Get details of insurance of particular ID from database to display in forms while updating
	public InsuranceBean getInsurancebyId(String insuranceid,String userid) throws Exception
	{
		InsuranceBean beans=new InsuranceBean();
		Connection con=null;	
		con=DBConnector.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from insurance_868 where insuranceid=? AND userid=?");
		ps.setString(1,insuranceid);
		ps.setString(2, userid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			beans.setInsuranceid(Integer.parseInt(rs.getString(8)));
			beans.setTypeofinsurance(rs.getString(2));
			if(!beans.getTypeofinsurance().equals("Body-injury"))
				beans.setVehicleid(rs.getInt(3));
			beans.setCoverage(rs.getInt(4));
			beans.setNoofmonths(rs.getInt(5));
			beans.setStartdate(rs.getString(6).substring(0, 10));
			return beans;
		}
		con.close();
		return beans;
	}
	
	//Update Insurance details
	public boolean update(InsuranceBean b) throws Exception
	{
		Connection con=DBConnector.getConnection();
		PreparedStatement ps;
		
		if(!b.getTypeofinsurance().equals("Body-injury")){
			ps=con.prepareStatement("update insurance_868 set type=?,vehicleid=?,COVERAGE_AMT=?,duration=?,START_DATE=? where insuranceid=?");
			ps.setString(1,b.getTypeofinsurance());
			ps.setString(2,""+b.getVehicleid());
			ps.setString(3,""+b.getCoverage());
			ps.setString(4,""+b.getNoofmonths());
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date1 = df.parse(b.getStartdate());
			java.sql.Date date2 = new java.sql.Date(date1.getTime());
			ps.setDate(5,date2);
			ps.setString(6,""+b.getInsuranceid());
			
		}
		else{
			ps=con.prepareStatement("update insurance_868 set type=?,COVERAGE_AMT=?,duration=?,START_DATE=? where insuranceid=?");
			ps.setString(1,b.getTypeofinsurance());
			ps.setString(2,""+b.getCoverage());
			ps.setString(3,""+b.getNoofmonths());
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date1 = df.parse(b.getStartdate());
			java.sql.Date date2 = new java.sql.Date(date1.getTime());
			ps.setDate(4,date2);
			ps.setString(5,""+b.getInsuranceid());
		}
		int a=ps.executeUpdate();
		con.close();
		if(a==0){
			return false;
		}
		else 
			return true;
	}
	
	// delete an insurance of particular ID
	public boolean delete(String insuranceid,String userid) throws Exception
	{
		Connection con=DBConnector.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from insurance_868 where insuranceid=? AND userid=?");
		ps.setString(1,insuranceid);
		ps.setString(2, userid);
		int a=ps.executeUpdate();
		con.close();
		if(a==0){
			return false;
		}
		else
			return true;	
	}
	
	//get details all insurances registered by a user 
	public Vector<InsuranceBean>  getInsurances(String userid) throws Exception
	{
		Vector<InsuranceBean> insurances=new Vector<InsuranceBean>();
		
		Connection con=null;
		
		con=DBConnector.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select * from insurance_868 where userid=?");
		
		ps.setString(1,userid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			InsuranceBean beans=new InsuranceBean();
			beans.setInsuranceid(Integer.parseInt(rs.getString(8)));
			beans.setTypeofinsurance(rs.getString(2));
			beans.setVehicleid(rs.getInt(3));
			beans.setCoverage(rs.getInt(4));
			beans.setNoofmonths(rs.getInt(5));
			beans.setStartdate(rs.getString(6).substring(0, 10));
			beans.setPremium(rs.getInt(7));
			insurances.add(beans);
		}
		con.close();
		return insurances;
	}
}
