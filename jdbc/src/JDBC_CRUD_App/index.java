package JDBC_CRUD_App;
import java.util.Scanner;
public class Display {
	public static void main(String[] args) {
		int choice =0;
		Scanner sc=new Scanner(System.in);
		System.out.println("-----------JDBC CRUD Application----------");
		System.out.println("Enter your choice::");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:System.out.println("1.*******Insert Operation*******");
			   Insert.insert();
			   break;
		case 2:System.out.println("2.******Select Operation*******");
				Select.select();
				break;
		case 3:System.out.println("3.******Update Operation********");
		 		Update.update();
		 		break;
		case 4:System.out.println("4.******Delete Operation********");
		 		Delete.delete();
		 		break;
		 default:System.out.println("Invalid Choice!!");
		
		}
		sc.close();
	}
}
