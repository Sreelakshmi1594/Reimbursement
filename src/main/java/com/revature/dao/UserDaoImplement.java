package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;

public class UserDaoImplement implements UserDao{
	
	
	 private UserDbConnect userCon;
	
	 public UserDaoImplement() { 
		
		userCon = new UserDbConnect();
		
	}

	@Override
	
	// getting all user 
	public List getAll() {
		// TODO Auto-generated method stub
		
		List<User> UserDetails = new ArrayList<>();		
		try(Connection con= userCon.getDbConnection()){
			String sql = "select * from ERS_USER";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				UserDetails.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
				}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(UserDetails);
		return UserDetails;
		
	}

	@Override
	public Object checkLogin(String emailId, String password) {
		// TODO Auto-generated method stub
		User user= new User();
		try(Connection con= userCon.getDbConnection()){
			String sql = "select * from ERS_USER where USER_EMAIL = ? and ERS_PASSWORD = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, emailId);
	        ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setUserId(rs.getInt("ERS_USERS_ID"));
				user.setUserName(rs.getString("ERS_USERNAME"));
				user.setPassword(rs.getString("ERS_PASSWORD"));
	            user.setFirstName(rs.getString("USER_FIRST_NAME"));
	            user.setLastName(rs.getString("USER_LAST_NAME"));
	            user.setEmail(rs.getString("USER_EMAIL"));
	            user.setRole_id(rs.getInt("USER_ROLE_ID"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(user);
		return user;
		
	}

}
