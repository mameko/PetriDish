package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.EmployeeAppManageEMTestBean;
import ejbs.EmployeeExtScoptEMTestBean;
import ejbs.EmployeeTxScopeEMTestBean;
import entities.Employee;

/**
 * Servlet implementation class AServletCallsEJB
 */
@WebServlet("/AServletCallsEJB2")
public class AServletCallsEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	private EmployeeTxScopeEMTestBean empAccessBean;

	@EJB
	private EmployeeExtScoptEMTestBean empExtVersionBean;

	@EJB
	private EmployeeAppManageEMTestBean empAppManagedBean;

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {

		// tx scope exmaple.
		System.out.println("tx scope exmaple.");
		Employee empFound = empAccessBean.findEmployee();
		request.setAttribute("empfound", empFound);
		empAccessBean.setEmployeeSalary(100);
		System.out.println();

		// ext scope exmaple
		System.out.println("ext scope exmaple.");
		Employee empFoundExt = empExtVersionBean.findEmployee();
		empExtVersionBean.setEmployeeSalary(200);
		System.out.println();

		// app-managed example
		System.out.println("app-managed example.");
		empAppManagedBean.init();
		Employee empAppManaged = empAppManagedBean.findEmployee();
		empAppManagedBean.setEmployeeSalary(300);
		empAppManagedBean.distroy();
		System.out.println();

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Result.jsp");
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
