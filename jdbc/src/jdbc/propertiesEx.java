package jdbc;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.SQLException;
public class propertiesEx {
	private propertiesEx()
	{
	}
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getJdbcConnection() throws SQLException,IOException
	{
		FileInputStream fis=new FileInputStream("D:\\Java\\jdbc\\src\\jdbc\\application.properties");
		Properties p=new Properties();
		p.load(fis);
		Connection con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
		return con;
	}
	public static void cleanUp(Connection con,Statement stmt,ResultSet res) throws SQLException
	{
		if(con!=null)
		{
			con.close();
		}
		if(stmt!=null)
		{
			stmt.close();
		}
		if(res!=null)
		{
			res.close();
		}
	}
}
