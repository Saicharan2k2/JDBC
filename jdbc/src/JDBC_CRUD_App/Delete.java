package JDBC_CRUD_App;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import util.JDBCUtil;
public class Delete {
	//public static void main(String[] args) {
		public static void delete(){
			Connection con=null;
			PreparedStatement pstmt=null;
			Scanner sc=null; 
		try
		{
			con=JDBCUtil.getJDBCConnection();
			String deleteQry="delete from details where sid=?";
			if(con!=null)
			{
				pstmt=con.prepareStatement(deleteQry);
			}
			if(pstmt!=null)
			{
				sc=new Scanner(System.in);
				System.out.println("Enter id::");
				int sid=sc.nextInt();
				pstmt.setInt(1, sid);
				int rows=pstmt.executeUpdate();
				System.out.println("Deletion successfull!!\n no.of  rows deleted ::"+rows);
			}
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				JDBCUtil.cleanUp(con, pstmt, null);
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//}
}
