package penetration.testing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrossSiteScripting
 */
@WebServlet("/CrossSiteScripting")
public class CrossSiteScripting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrossSiteScripting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("passwd");
		
//		if(!user.equalsIgnoreCase("admin") && !pwd.equalsIgnoreCase("admin")){
			request.setAttribute("user", user);
			request.setAttribute("passwd", pwd);
			PrintWriter pw = response.getWriter();
			pw.write("Inside----------------- doGet method of XSS Servlet!\nuser name: "+user+"password= "+pwd);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/homePage.jsp");
//			view.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
