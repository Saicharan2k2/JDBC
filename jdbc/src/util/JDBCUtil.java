package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	private JDBCUtil()
	{
	}
	public static Connection getJDBCConnection() throws SQLException,IOException
	{
		FileInputStream fis=new FileInputStream("D:\\Java\\jdbc\\src\\JDBC_CRUD_App\\application.properties");
		Properties p=new Properties();
		p.load(fis);
		Connection con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
		return con;
	}
	public static void cleanUp(Connection con,PreparedStatement pstmt,ResultSet res)throws SQLException
	{
		if(con!=null) {
			con.close();
		}
		if(pstmt!=null) {
			pstmt.close();
		}
		if(res!=null) {
			res.close();
		}
	}
}
