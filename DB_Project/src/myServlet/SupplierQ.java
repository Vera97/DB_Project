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
 * Servlet implementation class SupplierQ
 */
@WebServlet("/SupplierQ")
public class SupplierQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierQ() {
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
		String SupplierQ = "";
		
		List<Bean> rs = null;
		try {
			rs = myDao.SupplierQ(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Bean b : rs){
			SupplierQ += "s_suppkey="+b.s_suppkey+"    s_name="+b.s_name+"    s_address="+b.s_address+"    s_nationkey="+b.s_nationkey+
					"    s_phone="+b.s_phone+"    s_acctbal="+b.s_acctbal+"    s_comment="+b.s_comment+"\n";
		}
		request.setAttribute("SupplierQ", SupplierQ);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
