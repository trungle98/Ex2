package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BaoHanh;
import service.InsuranceServiceImpl;

/**
 * Servlet implementation class BuyInsurance
 */
public class BuyInsurance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InsuranceServiceImpl ins = new InsuranceServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyInsurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// InsuranceServiceImpl ins = new InsuranceServiceImpl();
		ArrayList<String> listInsurance = new ArrayList<String>();
		for (BaoHanh b : ins.GetAllInsurance()) {
			listInsurance.add(b.getTenGoi());
		}
		listInsurance.remove(0);
		String name = request.getParameter("buy");
		request.setAttribute("listInsurance", listInsurance);
		request.setAttribute("name", name);
		RequestDispatcher rd = request.getRequestDispatcher("muabaohiem.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bks = request.getParameter("buy");
		String typeOfInsurance = request.getParameter("listInsurance");
		System.out.println("bks:"+bks+"type:"+typeOfInsurance);
		if (ins.CheckBuyInsurance(bks)) {
			request.getRequestDispatcher("muathanhcong.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("muathatbai.jsp").forward(request, response);
		}

	}

}
