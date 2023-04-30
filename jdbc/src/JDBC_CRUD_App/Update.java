package JDBC_CRUD_App;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import util.JDBCUtil;
public class Update {
	//public static void main(String[] args) {
		public static void update(){
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner sc=null;
		try
		{
			con=JDBCUtil.getJDBCConnection();
			String updateQry="update details set name=? where sid=?";
			if(con!=null)
			{
				pstmt=con.prepareStatement(updateQry);
			}
			if(pstmt!=null) {
				sc=new Scanner(System.in);
				System.out.println("Enter id ::");
				int sid=sc.nextInt();
				System.out.println("Enter name ::");
				String sname=sc.next();
				pstmt.setInt(1, sid);
				pstmt.setString(2, sname);
				int rows=pstmt.executeUpdate();
				System.out.println("Updation successfull!! \n no .of rows updated ::"+rows);
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
		//}
	}
	}
}
