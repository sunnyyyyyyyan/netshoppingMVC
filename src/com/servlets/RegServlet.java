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
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		String user=request.getParameter("userName");
	    String password1=request.getParameter("pwd");
	    String password2=request.getParameter("pwd1");
	    String sex=request.getParameter("sex");
	    String interests[]=request.getParameterValues("interest");
	    
		//��֤����
		if(user==null || user.equals("") || password1==null || password1.equals("") || password2==null || password2.equals("")
				|| sex==null || sex.equals("") || interests==null || interests.equals("")){
			request.setAttribute("mess", "����Ϊ��!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request,response);
			return;
		}
		if(password1.equals(password2)==false){
			request.setAttribute("mess","�����������벻һ��");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request,response);
	    	return;
	    }
		//��������
		//��ѯ�Ƿ��Ѿ�����
		String sql = "select * from userinfo where userName='"+user+"'";
		DataProcess dataProcess = new DataProcess();
		Vector<Vector<String>>rows = dataProcess.getData(sql);
		if(rows.size()>0){
			request.setAttribute("mess", "���û��Ѵ���!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request,response);
			return;
		}
		//����String[]->String
		String strInterest="";
		for(int i=0;i<interests.length;i++){
			strInterest+=interests[i]+", ";
		}
		//�����Ϊ�գ���ȥ��ĩβ�ġ�,��
		if(!strInterest.equals("")){
			strInterest=strInterest.substring(0, strInterest.length()-2);
		}
		sql = "insert into userinfo(userName,password,sex,interest) values('"+user+"','"+password1+"','"+sex+"','"+strInterest+"')";
		dataProcess.update(sql);
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
