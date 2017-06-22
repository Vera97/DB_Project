package myServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myPackage.Dao;

/**
 * Servlet implementation class RegionD
 */
@WebServlet("/RegionD")
public class RegionD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionD() {
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
		String name = request.getParameter("name")==null?"":request.getParameter("name");
		String comment = request.getParameter("comment")==null?"":request.getParameter("comment");
		if(regionkey!=""){
		    if(myDao.RegionD1(regionkey, name, comment))
			     request.setAttribute("RegionD", "deletion successed!");
		    else request.setAttribute("RegionD", "deletion failed!");
		}
		else{
			if(myDao.RegionD2(name, comment))
			     request.setAttribute("RegionD", "deletion successed!");
		    else request.setAttribute("RegionD", "deletion failed!");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
