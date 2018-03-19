package com.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataBase.DataProcess;

/**
 * Servlet implementation class SortProductServlet
 */

public class SortProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sortid = request.getParameter("sortid");
		
		String sql = "select id,name,price,img,sale from product where sort='"+sortid+"'";
		DataProcess dataProcess = new DataProcess();
		Vector<Vector<String>>sortProduct = dataProcess.getData(sql);
		request.setAttribute("sortProduct", sortProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sort.jsp");
		dispatcher.forward(request,response);
	}

}
