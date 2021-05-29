package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conector {
	
	public Connection getConnection() {
	    try {
	        return DriverManager.getConnection("jdbc:mysql://localhost/db_pokemon", "root", "1234qwer");
	    } catch (SQLException excecao) {
	        throw new RuntimeException(excecao);
	    }
}
	

}
