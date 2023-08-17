package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JdbcConnection {
public static void main(String[] args) throws SQLException {
	
	//Register the Database
	//Register the Driver
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	//Get connection for database
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/girish", "root", "root");
	
	//Create Statement
	Statement statement = connection.createStatement();
	String query = "select * from doctor;";
	
	//Execute Query
	ResultSet result = statement.executeQuery(query);
	while (result.next()) {
		System.out.println(result.getString(1)+" | "+result.getString(2)+" | "+result.getString(3)+" | "+result.getString(4)+" | "+result.getString(5));
		}
	
	//Close the Database
	connection.close();
}
}
