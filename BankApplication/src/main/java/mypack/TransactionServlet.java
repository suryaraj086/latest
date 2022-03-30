package mypack;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.APILayer;
import db.AccountInfo;
import myexception.CustomException;
import utilhelper.Utility;

public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TransactionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

		String cust = request.getParameter("customer");
		APILayer logicLayer = (APILayer) request.getServletContext().getAttribute("logic");
		try {
			long fromAcc = Long.parseLong(Utility.nullChecker(request.getParameter("fromaccount")));
			long toAcc = Long.parseLong(Utility.nullChecker(request.getParameter("toaccount")));
			long amount = Long.parseLong(Utility.nullChecker(request.getParameter("amount")));
			long fromId = 0;
			if (cust != null) {
				fromId = Long.parseLong(request.getParameter("fromid"));
			} else {
				fromId = logicLayer.persistLayer.getId(fromAcc);

			}
			long toId = logicLayer.persistLayer.getId(toAcc);
			logicLayer.readFile();
			logicLayer.deposit(toAcc, toId, amount);
			logicLayer.withdrawal(fromAcc, fromId, amount);

			if (cust == null || cust.equals("null")) {
				Map<Long, Map<Long, AccountInfo>> accMap = logicLayer.cache.accountMap;
				request.setAttribute("LoginController", accMap);
				RequestDispatcher rd = request.getRequestDispatcher("accountdetails.jsp?message=Transaction Successful");
				rd.forward(request, response);
			} else {
				Map<Long, AccountInfo> userMap = null;
				try {
					HttpSession session = request.getSession();
					userMap = logicLayer.retrieveAccount((long) session.getAttribute("customerId"));
				} catch (CustomException e) {
					e.printStackTrace();
				}
				request.setAttribute("userMap", userMap);
				RequestDispatcher rd = request
						.getRequestDispatcher("customeraccount.jsp?message=Transaction Successful");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | CustomException | SQLException e) {
			request.setAttribute("errorMessage", e.getMessage());
			if (cust == null || cust.equals("null")) {
				RequestDispatcher rd = request.getRequestDispatcher("banktransferadmin.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("banktransfer.jsp");
				rd.forward(request, response);
			}
		}
	}
}
