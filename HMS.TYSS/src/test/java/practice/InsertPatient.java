package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertPatient {
public static void main(String[] args) throws SQLException {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/girish", "root", "root");
	Statement statement = connection.createStatement();
	String query = "insert into doctor values(3, 'Vickram', '2023/07/21', 'Fever', 'Dolo 650');";
	int result = statement.executeUpdate(query);
	if(result>0) {
		System.out.println("Table Updated successfully");
	}
	else {
		System.err.println("Table not updated successfully");
	}
	connection.close();
}
}
