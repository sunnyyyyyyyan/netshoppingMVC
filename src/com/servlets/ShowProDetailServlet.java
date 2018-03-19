package com.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Product;
import com.dataBase.DataProcess;

/**
 * Servlet implementation class ShowProDetailServlet
 */
public class ShowProDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接收数据
		String id = request.getParameter("id");
		//验证数据 
		//系统传的数据不需要验证
		
		//处理数据
		String sql = "select * from product where id="+id;
		DataProcess dataProcess = new DataProcess();
		Vector<Vector<String>>proDetails = dataProcess.getData(sql);
		Vector<String> proDetail = proDetails.get(0);
		
		Product product = new Product();
		product.setId(Integer.parseInt(proDetail.get(0)));
		product.setName(proDetail.get(1));
		product.setSort(Integer.parseInt(proDetail.get(2)));
		product.setPrice(Float.parseFloat(proDetail.get(3)));
		product.setOneprice(Float.parseFloat(proDetail.get(4)));
		product.setImg(proDetail.get(5));
		product.setDate(proDetail.get(6));
		product.setSale(Integer.parseInt(proDetail.get(07)));
		product.setFace(proDetail.get(8));
		product.setBody(proDetail.get(9));
		product.setLength(Float.parseFloat(proDetail.get(10)));
		product.setQuantity(Integer.parseInt(proDetail.get(11)));
		product.setSource(proDetail.get(12));
		
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("item.jsp");
		dispatcher.forward(request,response);
	}

}
