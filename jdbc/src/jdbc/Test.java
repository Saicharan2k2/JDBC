package jdbc;
import java.sql.*;
class Test
{
	public static void main(String []args)
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql:///sai";
			String user="root";
			String pass="root";
			con=DriverManager.getConnection(url,user,pass);
			stmt=con.createStatement();
			String qry="select sid,name,age from details";
			res=stmt.executeQuery(qry);
			System.out.println("sid\tsname\tsage");
			while(res.next())
			{
				Integer sid=res.getInt(1);
				String name=res.getString(2);
				Integer age=res.getInt(3);
				System.out.println(sid+"\t"+name+"\t"+age);
			}
		}
		catch(ClassNotFoundException ce)
		{
		ce.printStackTrace();
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
			if(con!=null)
			{
				try {
					con.close();
				}
				catch(SQLException se)
				{
				 se.printStackTrace();
				}
			}
		}
	}
}
