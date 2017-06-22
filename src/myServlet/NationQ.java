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
 * Servlet implementation class NationQ
 */
@WebServlet("/NationQ")
public class NationQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NationQ() {
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
		String NationQ = "";
		
		List<Bean> rs = null;
		try {
			rs = myDao.NationQ(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Bean b : rs){
			NationQ += "n_nationkey="+b.n_nationkey+"    n_name="+b.n_name+"    n_regionkey="+b.n_regionkey+"    n_comment="+b.n_comment+"\n";
		}
		request.setAttribute("NationQ", NationQ);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
