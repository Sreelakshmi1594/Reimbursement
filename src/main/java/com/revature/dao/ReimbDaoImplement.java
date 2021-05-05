package com.revature.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.revature.model.ReimbursementModel;
import com.revature.model.User;
import com.revature.service.ReimbService;

public class ReimbDaoImplement implements ReimbursementDao {
	
	public final static Logger log = Logger.getLogger(ReimbDaoImplement.class);
	private UserDbConnect userCon;
	
	public ReimbDaoImplement() {
		// TODO Auto-generated constructor stub
		userCon = new UserDbConnect();
		log.info("database connected properly");
	}
	
	Random rand = new Random();
	int reimbid =456789713;
	int randreimbid =rand.nextInt(reimbid);

	@Override
	// get all reimbursement
	public List getAll() {
		// TODO Auto-generated method stub
		
		List<ReimbursementModel> reimbDetails = new ArrayList<>();
		try(Connection con= userCon.getDbConnection()){
			String sql = "select * from ERS_REIMBURSEMENT where REIMB_STATUS_ID =1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbDetails.add(new ReimbursementModel(rs.getInt(1), rs.getFloat(2), rs.getTimestamp(3),
						rs.getTimestamp(4),rs.getString(5),rs.getBinaryStream(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),
						rs.getInt(10)));
				}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(reimbDetails);
		log.info("Collected all reimbursement details");
		return reimbDetails;
	}

	@Override
	public List getReimbDetails(int author) {
		// TODO Auto-generated method stub
		List<ReimbursementModel> reimbDetails = new ArrayList<>();
		ReimbursementModel rModel = new ReimbursementModel();
		try(Connection con= userCon.getDbConnection()){
			String sql = "select * from ERS_REIMBURSEMENT where reimb_author = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, author);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbDetails.add(new ReimbursementModel(rs.getInt("REIMB_ID"),rs.getFloat("REIMB_AMOUNT"),rs.getString("REIMB_DESCRIPTION"),
						rs.getInt("REIMB_STATUS_ID")));

			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(reimbDetails);
		log.info("collected user details");
		return reimbDetails;
	}

	@Override
	public void update(int statusid, int reimbid) {
		// TODO Auto-generated method stub
		
		try(Connection con= userCon.getDbConnection()){
			PreparedStatement stmt=con.prepareStatement("update ERS_REIMBURSEMENT set REIMB_STATUS_ID=? where REIMB_ID =?");
			stmt.setInt(1, statusid);
	        stmt.setInt(2, reimbid);
		    stmt.executeUpdate(); 
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		updateResolvingTime(reimbid);
		log.info("updated status id");
		return;
	}
	
	
	@Override
	public void updateResolvingTime(int reimbid) {
		// TODO Auto-generated method stub
		LocalDate instant = LocalDate.now();
		try(Connection con= userCon.getDbConnection()){
			PreparedStatement stmt=con.prepareStatement("update ERS_REIMBURSEMENT set REIMB_RESOLVED=? where REIMB_ID =?");
			stmt.setObject(1,instant);
	        stmt.setInt(2, reimbid);
		    stmt.executeUpdate(); 
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		log.info("Updated resolving time");
		return;
	}

	@Override
	public void createReimb(float amount, String description, InputStream receipt, int authorId, int typeId) {
		// TODO Auto-generated method stub
		LocalDate instant = LocalDate.now();  
        System.out.println("1. from() method will return "+instant); 
        try(Connection con= userCon.getDbConnection()){
//        	con.setAutoCommit(false);
        	CallableStatement stmt=con.prepareCall("{call insert_reimbursement(?,?,?,?,?,?,?,?,?,?)}");
			
			stmt.setInt(1, randreimbid);
	        stmt.setFloat(2, amount);
	        stmt.setObject(3, instant);
	        stmt.setObject(4, instant);
	        stmt.setString(5, description);
	        stmt.setBinaryStream(6,receipt);
	        stmt.setInt(7, authorId);
	        stmt.setInt(8, 98987878);
	        stmt.setInt(9, 1);
	        stmt.setInt(10, typeId);
		    stmt.execute();  
			System.out.println("Applied");  
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
        
        log.info("sucessfully inserted new reimbursement record");
		
	}

	@Override
	public List gettingAccountStatus() {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	
	
	
	
	
	

}
