package org.sig.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sig.ejb.common.Bar;

/**
 * Servlet implementation class HolaServlet
 */
public class HolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private Bar obj;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HolaServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<head><title>Prueba</title></head>");
		writer.println("<body>");
		writer.println("    <h3>prueba para iniciar camunda</h3>");

		writer.println("    <p><b> FOO :</b> " + obj.Saludar() + "</p>");
		writer.println("<body>");
		writer.println("</html>");
		writer.close();
	}

}
