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
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class Q1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao myDao = new Dao();
		int size = Integer.parseInt(request.getParameter("size"));
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String ComplexQ = "";
		
		List<Bean> rs = null;
		try {
			rs = myDao.MCSQ(size, type, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Bean b : rs){
			ComplexQ += "s_acctbal="+b.s_acctbal+"    s_name="+b.s_name+"    n_name="+b.n_name+"    p_partkey="+b.p_partkey+"    p_mfgr="+b.p_mfgr+"    s_address="+b.s_address+"    s_phone="+b.s_phone+"    s_comment="+b.s_comment+"\n";
		}
		request.setAttribute("ComplexQ", ComplexQ);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	
		
	}

}
