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
		
		SimpleDateFormat stdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			
			st = conn.prepareStatement(
					"INSERT INTO seller"
					+"(Name, Email,aniversario)"
					+"VALUES"
					+"(?,?,?)",
					Statement.NO_GENERATED_KEYS
					);
			st.setString(1, "Renan");
			st.setString(2, "renan@email.com");
			st.setDate(3, new java.sql.Date(stdf.parse("02/07/1997").getTime()));
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
			ResultSet rs =	st.getGeneratedKeys();
			while (rs.next()) {
				int id = rs.getInt(1);
				System.out.println("Done id = "+id);
			}
			}else {
				System.out.println("No line affected!");
			}
			
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
