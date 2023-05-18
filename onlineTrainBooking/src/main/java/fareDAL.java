import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class fareDAL {

	public double getFares(String a,String b,String tno,String classType) {
		Double fare = 0.0;
		Double tcost=0.0;
		
		try {
			

			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
			CallableStatement cstmt = c.prepareCall("CALL trainFare(?, ?, ?, ?, ?)");
			cstmt.setString(1, a);
			cstmt.setString(2, b);
			cstmt.setInt(3, Integer.parseInt(tno));
			cstmt.setString(4, classType);
			cstmt.setInt(5, 0);
			cstmt.registerOutParameter(1, Types.NUMERIC); // Register output parameter
			cstmt.execute();
			 Object fp = cstmt.getObject(1);
		     fare = (fp != null) ? ((Number) fp).doubleValue() : null;

			cstmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return fare;
	}
}
