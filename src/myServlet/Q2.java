package myServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myPackage.Bean;
import myPackage.Dao;

/**
 * Servlet implementation class Q2
 */
@WebServlet("/Q2")
public class Q2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao myDao = new Dao();
		String date = request.getParameter("date");
		String ComplexQ = "";
		
		List<Bean> rs = null;
		try {
			rs = myDao.OPCQ(date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Bean b : rs){
			ComplexQ += "o_orderpriority="+b.o_orderpriority+"    order_count="+b.order_count+"\n";
		}
		request.setAttribute("ComplexQ", ComplexQ);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	
	}

}
