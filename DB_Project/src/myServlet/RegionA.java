package myServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myPackage.Dao;

/**
 * Servlet implementation class RegionA
 */
@WebServlet("/RegionA")
public class RegionA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionA() {
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
		String regionkey = request.getParameter("regionkey");
		String name = request.getParameter("name");
		String comment = request.getParameter("comment");
		if(myDao.RegionA(regionkey, name, comment))
			request.setAttribute("RegionA", "insertion successed!");
		else request.setAttribute("RegionA", "insertion failed!");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
