package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class RegionQ
 */
@WebServlet("/RegionQ")
public class RegionQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionQ() {
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
		int regionkey;
		String name = request.getParameter("name")==null?"":request.getParameter("name");
		String comment = request.getParameter("comment")==null?"":request.getParameter("comment");
		String regionQ="";
		
		if(request.getParameter("regionkey")!=""){
			regionkey = Integer.parseInt(request.getParameter("regionkey"));
			List<Bean> rs = null;
			try {
				rs = myDao.RegionQ1(regionkey, name, comment);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(Bean b : rs){
				regionQ += "r_regionkey="+b.r_regionkey+"    r_name="+b.r_name+"    r_comment="+b.r_comment+"\n";
			}
			request.setAttribute("RegionQ", regionQ);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else{
			List<Bean> rs = null;
			try {
				rs = myDao.RegionQ2(name, comment);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Bean b : rs){
				regionQ += "r_regionkey="+b.r_regionkey+"    r_name="+b.r_name+"    r_comment="+b.r_comment+"\n";
			}
			request.setAttribute("RegionQ", regionQ);
			request.getRequestDispatcher("/index.jsp").forward(request, response);			
		}
		
		
	}

}
