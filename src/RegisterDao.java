import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/AEROPARKERDB";
	private String dbUname ="LIQUIBASE_AEROPARKERDB";
	private String dbPassword ="password";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	public String insert(Customer customer, String email) throws SQLException
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		Statement stmt=con.createStatement();
		String result = null;
		
		ResultSet RS = stmt.executeQuery("SELECT COUNT(*) AS total FROM customer where email ='" + email + "'");
        while (RS.next()) {
            if( RS.getInt("total") > 0 ) {
            	result = "Email address already existed";
            } else {
                result = "Registration completed successfully";
        		String sql = "insert into member values(?,?,?,?,?,?,?,?,?)";
        		
        		PreparedStatement ps;
        		try {
        		ps = con.prepareStatement(sql);
        		ps.setString(1, customer.getEmail());
        		ps.setString(2, customer.getTitle());
        		ps.setString(3, customer.getFirstName());
        		ps.setString(4, customer.getLastName());
        		ps.setString(5, customer.getAddressLine1());
        		ps.setString(6, customer.getAddressLine2());
        		ps.setString(7, customer.getCity());
        		ps.setString(8, customer.getPostcode());
        		ps.setString(9, customer.getTelephoneNumber());
        		ps.executeUpdate();
        		} catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        			result = "Data not entered";
        		}
        	 }
        }
        return result;
	}

}
