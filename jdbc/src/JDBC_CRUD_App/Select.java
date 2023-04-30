package JDBC_CRUD_App;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import util.JDBCUtil;
public class Select {
	//public static void main(String[] args) {
		public static void select() {
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner sc=null;
		ResultSet res=null;
		int sid=0;
		try
		{
			con=JDBCUtil.getJDBCConnection();
			String selectQry="select sid,name,age from details where sid=?";
			if(con!=null) {
				pstmt=con.prepareStatement(selectQry);
			}
			if(pstmt!=null) {
				sc=new Scanner(System.in);
				System.out.println("Enter id ::");
				sid=sc.nextInt();
				pstmt.setInt(1, sid);
				res=pstmt.executeQuery();
			}
			if(res!=null)
			{
				if(res.next())
				{
					System.out.println("SID\tNAME\tAGE");
					System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3));
				}
				else
				{
					System.out.println("Record not available for id:"+sid);
				}
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//}
}
