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
		Statement st = null;
		try {
			st = conn.createStatement();
			
			conn.setAutoCommit(false);
			
			int rows1 = st.executeUpdate("UPDATE vendedor "
					+ "SET salarioBase = 2000"
					+ "WHERE"
					+"DepartamentoId = 1"
					);
			
//			int x = 1;
	//		if (x>2) {
		//		System.out.println("Erro teste");
			//}
			
			
			int rows2 = st.executeUpdate("UPDATE vendedor "
					+ "SET salarioBase = 4000"
					+ "WHERE"
					+"DepartamentoId = 2"
					);
			
			conn.commit();
		
			System.out.println("rows1 = "+ rows1);
			System.out.println("rows2 = "+ rows2);
			
		} catch (SQLException e) {
			// TODO: handle exception
			try {
				conn.rollback();
				throw new DbException("Operação não concluída!"+ e.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DbException("Erro ao tentar abortar operação"+ e1.getMessage());
			}
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	
	}

}
