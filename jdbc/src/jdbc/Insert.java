package jdbc;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.SQLException;
public class Insert {
	public static void main(String [] args) throws SQLException
	{
		String url="jdbc:mysql:///sai";
		String user="root";
		String password="root";
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id::");
		int sid=sc.nextInt();
		System.out.println("Enter name::");
		String sname=sc.next();
		System.out.println("Enter age");
		int sage=sc.nextInt();
		String insqry=String.format("insert into details(`sid`,`name`,`age`) values ('%d','%s','%d')", sid,sname,sage);
		System.out.println("no .of rows affected :: "+stmt.executeUpdate(insqry));
		stmt.close();
		con.close();
		sc.close();
	}
}
