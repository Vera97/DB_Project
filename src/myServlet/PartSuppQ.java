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
 * Servlet implementation class PartSuppQ
 */
@WebServlet("/PartSuppQ")
public class PartSuppQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartSuppQ() {
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
		String partkey = request.getParameter("partkey")==null?"":request.getParameter("partkey");
		String PartSuppQ = "";
		
		List<Bean> rs = null;
		try {
			rs = myDao.PartSuppQ(partkey);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Bean b : rs){
			PartSuppQ += "ps_partkey="+b.ps_partkey+"    ps_suppkey="+b.ps_suppkey+"    ps_availqty="+b.ps_availqty+"    ps_supplycost="+b.ps_supplycost+"    ps_comment="+b.ps_comment+"\n";
		}
		request.setAttribute("PartQ", PartSuppQ);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
