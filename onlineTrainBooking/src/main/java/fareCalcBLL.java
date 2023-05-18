import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
public class fareCalcBLL {
	ArrayList<Double> individualFare =new ArrayList<>();
	
	
	public List<Double> personWiseFare(Double singleFare, ArrayList<passengerModel> passengers){
		ArrayList<passengerModel> finalPm=passengers;
		double fare=singleFare;
		double tcost=0.0;
		for(passengerModel a:finalPm) {
			 
			 Double ticketCost=0.0;
		     int age = Integer.parseInt(a.getAge());
		     //String gender = request.getParameter("gender" + i);
		     
		     if (age > 65 )//&& gender.equals("male")) || (age > 58 && gender.equals("female")))
					{ticketCost = fare * 0.75;System.out.print(ticketCost);}
			 else if (age < 12)
			 {			ticketCost = fare * 0.50;System.out.print(ticketCost);}
			 else
					ticketCost = fare;
		     
		     individualFare.add(ticketCost);
		     tcost+=ticketCost;
		}
		return individualFare;
	}
	public double totalFare(Double singleFare, ArrayList<passengerModel> passengers){
		ArrayList<passengerModel> finalPm=passengers;
		double fare=singleFare;
		double tcost=0.0;
		for(passengerModel a:finalPm) {
			 
			 Double ticketCost=0.0;
		     int age = Integer.parseInt(a.getAge());
		     //String gender = request.getParameter("gender" + i);
		     
		     if (age > 65 )//&& gender.equals("male")) || (age > 58 && gender.equals("female")))
					{ticketCost = fare * 0.75;System.out.print(ticketCost);}
			 else if (age < 12)
			 {			ticketCost = fare * 0.50;System.out.print(ticketCost);}
			 else
					ticketCost = fare;
		     
		     individualFare.add(ticketCost);
		     tcost+=ticketCost;
		}
		return tcost;
	}
	


	
}


