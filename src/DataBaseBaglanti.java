import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Singleton Desgin pattern  amaclanmistir.
public class DataBaseBaglanti {
	private String userName = "root";
	private String password = "41084108";
	private String dbUrl = "jdbc:mysql://localhost:3306/proje";
	public static Connection connect;

	public Connection getConnection() throws SQLException {
		if (connect == null)
			connect=DriverManager.getConnection(dbUrl, userName, password);
		return connect;
	}

}
