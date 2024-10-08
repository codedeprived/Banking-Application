package balanceInquiry;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDAO;
import login.Login; 

/**
 * Servlet implementation class BalanceInquiry
 */
@WebServlet("/BalanceInquiry")
public class BalanceInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceInquiry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BankDAO dao = new BankDAO ();
		
		/* servlet to servlet communication */
		String username = (String) request.getSession().getAttribute("username");
		int balance = dao.balanceInquiry(username);
		
		if(balance == -1)
		{
			response.sendRedirect("Dashboard/BalanceInquiry/BalanceInquiryFailed.jsp");
		}
		
		/* servlet to jsp communication */
		request.setAttribute("balance", balance);
		request.getRequestDispatcher("Dashboard/BalanceInquiry/BalanceInquiry.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
