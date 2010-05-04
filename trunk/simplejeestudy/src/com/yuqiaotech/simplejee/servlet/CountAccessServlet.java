package com.yuqiaotech.simplejee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class CountAccessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if("add".equals(request.getParameter("flag"))){
			String username=request.getParameter("username");
			request.setAttribute("username", username);
			HttpSession s=request.getSession();
			if(request.getParameter("username")!=null)
				s.setAttribute("username",username);
			request.getRequestDispatcher("/filterlistener/count_online_show.jsp").forward(request, response);
		} else {
			HttpSession s=request.getSession();
			s.removeAttribute("username");
			response.sendRedirect("filterlistener/count_online.jsp");
		}
	}
	

	
}
