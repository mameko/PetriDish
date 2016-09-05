package com.pan.jpa.myToyProject.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.jpa.myToyProject.ejb.EmployeeTxScopeEMTestBean;
import com.pan.jpa.myToyProject.entities.Employee;

/**
 * Servlet implementation class AServletCallsEJB
 */
@WebServlet("/AServletCallsEJB")
public class AServletCallsEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	private EmployeeTxScopeEMTestBean empAccessBean;

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {

		Employee empFound = empAccessBean.findEmployee();
		request.getSession().setAttribute("empfound", empFound);

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("Result.jsp");
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public AServletCallsEJB() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
