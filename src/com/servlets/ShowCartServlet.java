package com.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dataBase.DataProcess;

/**
 * Servlet implementation class ShowCartServlet
 */
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ�û���Ϣ
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		//��֤�û������Ƿ��Ѿ���½
		if(user==null){
			request.setAttribute("mess", "���ȵ�¼");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//�������ݣ������ݿ��л�ȡ�û��Ĺ��ﳵ��Ϣ
		String sql = "select cart.productid,name,price,cart.count,price*cart.count from cart,product where userName = '"+user+"' and product.id=cart.productid";
		DataProcess data = new DataProcess();
		Vector<Vector<String>> products = (Vector<Vector<String>>)data.getData(sql);
		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart_view.jsp");
		dispatcher.forward(request,response);
	}

}
