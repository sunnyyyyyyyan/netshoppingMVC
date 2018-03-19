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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��������
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("useName");
		String psd = request.getParameter("pwd");
		
		//��֤����
		if(user==null || user.equals("") || psd==null || psd.equals("")){
			request.setAttribute("mess", "����Ϊ��!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request,response);
			return;
		}
		//��������
		String sql = "select * from userinfo where userName='"+user+"' and password='"+psd+"' ";
		DataProcess dataProcess = new DataProcess();
		Vector<Vector<String>>rows = dataProcess.getData(sql);
		
		if(rows.size()>0){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
			return;
		}
		//��¼���ɹ�
		request.setAttribute("mess", "�û��������벻��ȷ!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
