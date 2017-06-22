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
 * Servlet implementation class CustomerQ
 */
@WebServlet("/CustomerQ")
public class CustomerQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerQ() {
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
		String name = request.getParameter("name")==null?"":request.getParameter("name");
		String CustomerQ = "";
		
		List<Bean> rs = null;
		try {
			rs = myDao.CustomerQ(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Bean b : rs){
			CustomerQ += "c_custkey="+b.c_custkey+"    c_name="+b.c_name+"    c_address="+b.c_address+"    c_nationkey="+b.c_nationkey+
					"    c_phone="+b.c_phone+"    c_acctbal="+b.c_acctbal+"    c_mktsegment="+b.c_mktsegment+"    c_comment="+b.c_comment+"\n";
		}
		request.setAttribute("CustomerQ", CustomerQ);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
