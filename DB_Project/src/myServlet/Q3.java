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
 * Servlet implementation class Q3
 */
@WebServlet("/Q3")
public class Q3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q3() {
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
			rs = myDao.RIRQ(date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Bean b : rs){
			ComplexQ += "c_name="+b.c_name+"    c_address="+b.c_address+"    n_name="+b.n_name+"    c_phone="+b.c_phone+"    c_acctbal="+b.c_acctbal+"    c_comment="+b.c_comment+"    revenue="+b.revenue+"\n";
		}
		request.setAttribute("ComplexQ", ComplexQ);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	
	}

}
