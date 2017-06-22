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
 * Servlet implementation class Q4
 */
@WebServlet("/Q4")
public class Q4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q4() {
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
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String ComplexQ = "";
		
		List<Bean> rs = null;
		try {
			rs = myDao.LVCQ(quantity);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Bean b : rs){
			ComplexQ += "c_name="+b.c_name+"    c_custkey="+b.c_custkey+"    o_orderkey="+b.o_orderkey+"    o_orderdate="+b.o_orderdate+"    o_totalprice="+b.o_totalprice+"    sum_quantity="+b.sum_quantity+"\n";
		}
		request.setAttribute("ComplexQ", ComplexQ);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
