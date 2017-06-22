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
 * Servlet implementation class PartQ
 */
@WebServlet("/PartQ")
public class PartQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartQ() {
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
		String PartQ = "";
		
		List<Bean> rs = null;
		try {
			rs = myDao.PartQ(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Bean b : rs){
			PartQ += "p_partkey="+b.p_partkey+"    p_name="+b.p_name+"    p_mfgr="+b.p_mfgr+"    p_brand="+b.p_brand+
					"    p_type="+b.p_type+"    p_size="+b.p_size+"    p_container="+b.p_container+"    p_retailprice="+b.p_retailprice+"    p_comment="+b.p_comment+"\n";
		}
		request.setAttribute("PartQ", PartQ);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
