

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class previewServlet
 */
@WebServlet("/previewServlet")
public class previewServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
    List<Double> individualFaresFinal;//=new ArrayList<>();;
    double total;
	//fareCalcBLL farecalc; 
    fareCalcBLL farecalc;
   // fareCalcBLL finalFarecalc;
	fareDAL singletktFare;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		singletktFare = new fareDAL();
		farecalc=new fareCalcBLL();
		//farecalc=new fareCalcBLL();
	}
    public previewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		String a = request.getParameter("to");
		String b = request.getParameter("from");
		String tno = request.getParameter("train_no");
		String classType = request.getParameter("train_class");
		
		
		double singleFare=singletktFare.getFares(a, b, tno, classType);
		
		String n1=request.getParameter("name1") ;
		String a1=request.getParameter("age1") ;
		String g1=request.getParameter("gender1") ;
		//=individualFare.get(0)
		String n2=request.getParameter("name2") ;
		String a2=request.getParameter("age2") ;
		String g2=request.getParameter("gender2"); 
		//individualFare.get(2)
		String n3=request.getParameter("name3") ;
		String a3=request.getParameter("age3") ;
		String g3=request.getParameter("gender3"); 
//individualFare.get(2)														
		String n4=request.getParameter("name4") 	;													
		String a4=request.getParameter("age4") 		;															
		String g4=request.getParameter("gender4");
//individualFare.get(3) 
		String n5=request.getParameter("name5") 	;	
		String a5=request.getParameter("age5") ;
		String g5=request.getParameter("gender5"); 
//=individualFare.get(4) 

		passengerModel pm1=new passengerModel();
		passengerModel pm2=new passengerModel();
		passengerModel pm3=new passengerModel();
		passengerModel pm4=new passengerModel();
		passengerModel pm5=new passengerModel();
		pm1.setName(n1);
		pm1.setAge(a1);
		pm1.setGender(g1);
		
		pm2.setName(n2);
		pm2.setAge(a2);
		pm2.setGender(g2);
		
		pm3.setName(n3);
		pm3.setAge(a3);
		pm3.setGender(g3);
		
		pm4.setName(n4);
		pm4.setAge(a4);
		pm4.setGender(g4);
		
		pm5.setName(n5);
		pm5.setAge(a5);
		pm5.setGender(g5);
		
		System.out.print(singleFare);
		ArrayList<passengerModel> passengers=new ArrayList<>();
		passengers.add(pm1);
		passengers.add(pm2);
		passengers.add(pm3);
		passengers.add(pm4);
		passengers.add(pm5);
		
		individualFaresFinal=farecalc.personWiseFare(singleFare, passengers);
		total=farecalc.totalFare(singleFare, passengers);
		
		
		
		pw.print(singleFare);
		pw.print(individualFaresFinal);
		pw.print(total);
		
		RequestDispatcher rd=request.getRequestDispatcher("preview.jsp");  
		
		  
		rd.forward(request, response);
		
	}

}
