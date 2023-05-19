package onlineTrainMVC;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class finalServlet
 */
@WebServlet("/finalServlet")
public class finalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public finalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ticketJson = request.getParameter("ticketJson");
		System.out.println("finalServelet" + ticketJson);
		String passengersJson = request.getParameter("passengersJson");
		System.out.println("finalServelet" + passengersJson);

		System.out.println(passengersJson);

		Gson gson = new Gson();
		ticketModel tm1 = gson.fromJson(ticketJson, ticketModel.class);
		ArrayList<passengerModel> al = gson.fromJson(passengersJson, new TypeToken<ArrayList<passengerModel>>() {
		}.getType());
		System.out.println(al.get(0).getName());
		PrintWriter pw = response.getWriter();
		pw.print("<html>\r\n" + "<head>\r\n" + "<title>Final</title></head>\r\n" + "<body>\r\n"
				+ "<h1>TICKET SUCCESSFULLY BOOKED </h1>\r\n" + "</body></html>\r\n" + "\r\n ");
		doGet(request, response);
	}

}