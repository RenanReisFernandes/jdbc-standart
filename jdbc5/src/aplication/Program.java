package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) throws ParseException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE"
					+"iD = ?");
			
			st.setInt(1, 5);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! rows affected "+ rowsAffected);
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	
	}

}
