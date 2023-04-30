package JDBC_CRUD_App;
import util.JDBCUtil;
import java.sql.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Insert {
		public static void insert() {
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner sc=null;
		try {
			con=JDBCUtil.getJDBCConnection();
			String insqry="insert into details(`sid`,`name`,`age`) values(?,?,?)";
			if(con!=null)
			{
				pstmt=con.prepareStatement(insqry);
			}
			if(pstmt!=null)
			{
				sc=new Scanner(System.in);
				System.out.println("Enter id ::");
				int sid=sc.nextInt();
				System.out.println("Enter name ::");
				String sname=sc.next();
				System.out.println("Enter age ::");
				int sage=sc.nextInt();
				pstmt.setInt(1, sid);
				pstmt.setString(2, sname);
				pstmt.setInt(3, sage);
				int rows=pstmt.executeUpdate();
				System.out.println("Record inserted successfully!! \nno.of rows changed ::"+rows);
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
}
