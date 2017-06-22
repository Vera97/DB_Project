package myServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myPackage.Dao;

/**
 * Servlet implementation class RegionU
 */
@WebServlet("/RegionU")
public class RegionU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionU() {
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
		String regionkey = request.getParameter("regionkey")==null?"":request.getParameter("regionkey");
		
		String regionkey2 = request.getParameter("regionkey2")==null?"":request.getParameter("regionkey2");
		String name2 = request.getParameter("name2")==null?"":request.getParameter("name2");
		String comment2 = request.getParameter("comment2")==null?"":request.getParameter("comment2");
		
		if(regionkey!=""){
		    if(myDao.RegionU1(regionkey, regionkey2, name2, comment2))
			     request.setAttribute("RegionU", "update successed!");
		    else request.setAttribute("RegionU", "update failed!");
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	
	}

}
