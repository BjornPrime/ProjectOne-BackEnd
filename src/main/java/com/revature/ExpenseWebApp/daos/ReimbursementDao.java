package com.revature.ExpenseWebApp.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.ExpenseWebApp.models.Reimbursement;
import com.revature.ExpenseWebApp.util.DatabaseConnect;

public class ReimbursementDao {
	
	public void createReimbursement(Reimbursement reimbursement) {
		
	}

	public static Reimbursement addReimbursement(Reimbursement reimbursement) {
		Connection conn = DatabaseConnect.conn;
		
		try {
			String query = "INSERT INTO reimbursements (amount, date_submitted, description, author, status, type) VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setBigDecimal(1, reimbursement.getAmount());
			statement.setTimestamp(2, reimbursement.getSubmitDate());
			statement.setString(3, reimbursement.getDescription());
			statement.setInt(4, reimbursement.getAuthor());
			statement.setInt(5, reimbursement.getStatus());
			statement.setInt(6, reimbursement.getType());
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
}
