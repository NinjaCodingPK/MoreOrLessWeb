package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Constants;
import model.Model;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		Model model = (Model)session.getAttribute("model");
		if(model == null) {
			model = new Model();
		}
		
		model.setBorders((int)session.getAttribute(Constants.MIN_BORDER_NAME),
				(int)session.getAttribute(Constants.MAX_BORDER_NAME));
		model.addTurn((int)session.getAttribute(Constants.TURN_NAME));
		
		request.setAttribute("result", model.checkUserNumber((int)session.getAttribute(Constants.TURN_NAME)));
		session.setAttribute(Constants.MIN_BORDER_NAME, model.getLowerBorder());
		session.setAttribute(Constants.MAX_BORDER_NAME, model.getUpperBorder());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
