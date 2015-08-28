package main.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vulnerable
 */
@WebServlet("/Vulnerable")
public class Vulnerable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vulnerable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("n");
		String pwd = request.getParameter("p");
		PrintWriter pw = response.getWriter();
		if(name.equals("Manoj") && pwd.equals("pwd")){
			pw.write("Inside doGet method of Vulnerable Servlet!\nTEST PASSED!: "+name);
		}
		else
		pw.write("Test Failed! = "+name+"\t"+pwd);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.write("Inside doPost method of Vulnerable Servlet!");
	}

}
