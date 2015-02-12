package com.ilp.fq.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ilp.fq.beans.UserBean;
import com.ilp.fq.utilities.DBConnector;

public class UserDAO {
	private String role=null;
	private String status=null;
	public String getStatus(){
		return status;
	}
	public String getRole(){
		return role;
	}
	public int changepd(String newpwd,String old,String username) throws Exception{
		Connection con=null;
		int res=1;
		System.out.println(username);
		try {
			
			con=DBConnector.getConnection();
			Statement statement=con.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from Login_868 where userid='"+username+"'");
			
			while(resultSet.next()){
				String dbpwd=resultSet.getString(2);
				System.out.println(dbpwd);
				if(dbpwd.equals(old)){
					statement.executeUpdate("update Login_868 set password='"+newpwd+"' where password='"+old+"'");
				}
				else{
					res=0;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBConnector.close(con);
			
		}
		return res;
	}
	public UserBean getUserDetails(String username)throws Exception{
		UserBean userbean=null;
		Connection con=null;
		try {
			con=DBConnector.getConnection();
			
			
			
			Statement statement=con.createStatement();
			
			ResultSet resultSet=statement.executeQuery("select * from register_868 where userid='"+username+"'");
			userbean=new UserBean();
			while(resultSet.next()){
				
				userbean.setUname(resultSet.getString(1));
				userbean.setName(resultSet.getString(2));		
				userbean.setGender(resultSet.getString(3));
				userbean.setDob(resultSet.getString(4));
				userbean.setMailId(resultSet.getString(5));
				userbean.setAge(Integer.parseInt(resultSet.getString(6)));
				userbean.setLicenceStatus(resultSet.getString(7));
				userbean.setSsn(resultSet.getString(8));
				userbean.setOccupation(resultSet.getString(9));
				userbean.setAnnualIncome(Integer.parseInt(resultSet.getString(10)));
				userbean.setEducation(resultSet.getString(11));	
			}
			
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				DBConnector.close(con);
				
			}
		return userbean;
	}
	public boolean editUser(UserBean userbean) throws Exception{
		Connection con=null;
		
		try {
			con=DBConnector.getConnection();
			
			String uname=userbean.getUname();
			String name=userbean.getName();
			String gender=userbean.getGender();
			String dateofbirth=userbean.getDob();
			String emailid=userbean.getMailId();
			int age=userbean.getAge();
			String status=userbean.getLicenceStatus();
			String ssn=userbean.getSsn();
			String occupation=userbean.getOccupation();
			int income=userbean.getAnnualIncome();
			String education=userbean.getEducation();
			
			String pwd=name.substring(0,4);
		    char ch;
		    int count=0;
		    for(int i=0;i<name.length();i++)
		    {
		    	 ch=name.charAt(i);
		    	 if(ch=='a'||ch=='A'||ch=='e'||ch=='E'||ch=='i'||ch=='I'||ch=='o'||ch=='O'||ch=='u'||ch=='U')
		    	   count++;
		    }
		    
		    pwd=pwd+"@"+count;
		    userbean.setPwd(pwd);
		    Statement regstatement=con.createStatement();
		    System.out.println("insert into	Register_868 values('"+uname+"','"+name+"','"+gender+"','"+dateofbirth+"','"+emailid+"',"+age+",'"+status+"','"+ssn+"','"+occupation+"',"+income+",'"+education+"')");
		    regstatement.executeUpdate("update Register_868 set dateofbirth=to_date('"+dateofbirth+"', 'yyyy-mm-dd'),name='"+name+"',userid='"+uname+"',gender='"+gender+"',emailid='"+emailid+"',age="+age+",licencestatus='"+status+"',occupation='"+occupation+"',annualincome='"+income+"',education='"+education+"',ssn='"+ssn+"' where userid='"+uname+"'");
		    
		    
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
	public boolean registerUser(UserBean userbean) throws Exception{
		Connection con=null;
		
		try {
			con=DBConnector.getConnection();
			
			String uname=userbean.getUname();
			String name=userbean.getName();
			String gender=userbean.getGender();
			String dateofbirth=userbean.getDob();
			String emailid=userbean.getMailId();
			int age=userbean.getAge();
			String status=userbean.getLicenceStatus();
			String ssn=userbean.getSsn();
			String occupation=userbean.getOccupation();
			int income=userbean.getAnnualIncome();
			String education=userbean.getEducation();
			
			String pwd=name.substring(0,4);
		    char ch;
		    int count=0;
		    for(int i=0;i<name.length();i++)
		    {
		    	 ch=name.charAt(i);
		    	 if(ch=='a'||ch=='A'||ch=='e'||ch=='E'||ch=='i'||ch=='I'||ch=='o'||ch=='O'||ch=='u'||ch=='U')
		    	   count++;
		    }
		    
		    pwd=pwd+"@"+count;
		    userbean.setPwd(pwd);
		    Statement regstatement=con.createStatement();
		    System.out.println("insert into	Register_868 values('"+uname+"','"+name+"','"+gender+"','"+dateofbirth+"','"+emailid+"',"+age+",'"+status+"','"+ssn+"','"+occupation+"',"+income+",'"+education+"')");
		    regstatement.executeUpdate("insert into	Register_868 values('"+uname+"','"+name+"','"+gender+"',to_date('"+dateofbirth+"', 'yyyy-mm-dd'),'"+emailid+"',"+age+",'"+status+"','"+ssn+"','"+occupation+"',"+income+",'"+education+"')");
		    
		    Statement loginstatement=con.createStatement();
		    loginstatement.executeUpdate("insert into Login_868 values('"+uname+"','"+pwd+"','user','active')");
		    
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
	public boolean checkCredentials(String username,String password) throws Exception{
		Connection con=null;
		
		try {
			con=DBConnector.getConnection();
			Statement statement=con.createStatement();
			
			
			ResultSet resultSet=statement.executeQuery("select * from Login_868 where userid='"+username+"' AND password='"+password+"'");
			System.out.println(resultSet);
			
			while(resultSet.next()){
					role=resultSet.getString(3);
					status=resultSet.getString(4);
					return true;
				}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
				
			DBConnector.close(con);
				
		}
		return false;
		
	}
}
