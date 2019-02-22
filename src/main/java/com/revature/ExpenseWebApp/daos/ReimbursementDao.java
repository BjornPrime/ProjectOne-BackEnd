package com.revature.ExpenseWebApp.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ExpenseWebApp.dto.DisposalRequestDTO;
import com.revature.ExpenseWebApp.models.Reimbursement;
import com.revature.ExpenseWebApp.util.DatabaseConnect;

public class ReimbursementDao {
	
	public void createReimbursement(Reimbursement reimbursement) {
		
	}

	public static Reimbursement addReimbursement(Reimbursement reimbursement) {
		Connection conn = DatabaseConnect.conn;
		
		try {
			String query = "INSERT INTO reimbursements (amount, date_submitted, description, author, status, type, author_name) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setBigDecimal(1, reimbursement.getAmount());
			statement.setTimestamp(2, reimbursement.getSubmitDate());
			statement.setString(3, reimbursement.getDescription());
			statement.setInt(4, reimbursement.getAuthor());
			statement.setInt(5, reimbursement.getStatus());
			statement.setInt(6, reimbursement.getType());
			statement.setString(7, reimbursement.getAuthorName());
//			statement.setBlob(8, reimbursement.getDocumentation());
//			statement.setString(4, reimbursement.getDocumentation());
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				reimbursement.setReimbID(resultSet.getInt("id"));
				return reimbursement;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Reimbursement> retrieveReimbursements() {
		Connection conn = DatabaseConnect.conn;
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM reimbursements";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Reimbursement reimb = new Reimbursement();
				
				reimb.setAmount(resultSet.getBigDecimal("amount"));
				reimb.setType(resultSet.getInt("type"));
				reimb.setSubmitDate(resultSet.getTimestamp("date_submitted"));
				reimb.setStatus(resultSet.getInt("status"));
				reimb.setAuthor(resultSet.getInt("author"));
				reimb.setAuthorName(resultSet.getString("author_name"));
				reimb.setReimbID(resultSet.getInt("id"));
		//		reimb.setDocumentation(resultSet.getBinaryStream("receipt"));
				reimbursements.add(reimb);
			}
			if(reimbursements.size() < 1) {
				return null;
			}
			return reimbursements;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<Reimbursement> retrieveReimbursements(int userID) {
		Connection conn = DatabaseConnect.conn;
		
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM users WHERE id = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setInt(1, userID);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				if(resultSet.getInt("user_role") == 2) {
					return retrieveReimbursements();
				}
				
				query = "SELECT * FROM reimbursements WHERE author = ?";
				
				statement = conn.prepareStatement(query);
				
				statement.setInt(1,userID);
				
				resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					Reimbursement reimb = new Reimbursement();
					reimb.setAmount(resultSet.getBigDecimal("amount"));
					reimb.setType(resultSet.getInt("type"));
					reimb.setSubmitDate(resultSet.getTimestamp("date_submitted"));
					reimb.setStatus(resultSet.getInt("status"));
					reimb.setAuthor(resultSet.getInt("author"));
					reimb.setReimbID(resultSet.getInt("id"));
					reimb.setAuthorName(resultSet.getString("author_name"));
		//			reimb.setDocumentation(resultSet.getBinaryStream("receipt"));
					reimbursements.add(reimb);
				}
				if(reimbursements.size() < 1) {
					return null;
				}
				return reimbursements;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static Reimbursement retrieveDetails(int entryID) {
		Connection conn = DatabaseConnect.conn;
		Reimbursement reimbursement = new Reimbursement();
		
		try {
			String query = "SELECT * FROM reimbursements WHERE id = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setInt(1, entryID);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				reimbursement.setAmount(resultSet.getBigDecimal("amount"));
				reimbursement.setAuthor(resultSet.getInt("author"));
				reimbursement.setAuthorName(resultSet.getString("author_name"));
				reimbursement.setDescription(resultSet.getString("description"));
				reimbursement.setReimbID(resultSet.getInt("id"));
				reimbursement.setStatus(resultSet.getInt("status"));
				if(reimbursement.getStatus() > 1) {
					reimbursement.setResolutionDate(resultSet.getTimestamp("date_resolved"));
					reimbursement.setResolver(resultSet.getInt("resolver"));
				}
				reimbursement.setSubmitDate(resultSet.getTimestamp("date_submitted"));
				reimbursement.setType(resultSet.getInt("type"));
	//			reimbursement.setDocumentation(resultSet.getBinaryStream("receipt"));
				return reimbursement;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void updateReimbursement(DisposalRequestDTO disposal) {
		Connection conn = DatabaseConnect.conn;
		
		try {
			String query = "UPDATE reimbursements SET status = ? WHERE id = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setInt(1, disposal.getStatusUpdate());
			statement.setInt(2, disposal.getReimbursementID());
			
			ResultSet resultSet = statement.executeQuery();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
