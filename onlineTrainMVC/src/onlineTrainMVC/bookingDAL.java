package onlineTrainMVC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class bookingDAL {

	public long getPNR() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
			Statement s = c.createStatement();
			String query = "insert into gv_tickets values(";
			s.executeUpdate(query);
			s.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
