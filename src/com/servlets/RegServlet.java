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
		//接收数据
		request.setCharacterEncoding("utf-8");
		String user=request.getParameter("userName");
	    String password1=request.getParameter("pwd");
	    String password2=request.getParameter("pwd1");
	    String sex=request.getParameter("sex");
	    String interests[]=request.getParameterValues("interest");
	    
		//验证数据
		if(user==null || user.equals("") || password1==null || password1.equals("") || password2==null || password2.equals("")
				|| sex==null || sex.equals("") || interests==null || interests.equals("")){
			request.setAttribute("mess", "不能为空!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request,response);
			return;
		}
		if(password1.equals(password2)==false){
			request.setAttribute("mess","两次密码输入不一致");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request,response);
	    	return;
	    }
		//处理数据
		//查询是否已经存在
		String sql = "select * from userinfo where userName='"+user+"'";
		DataProcess dataProcess = new DataProcess();
		Vector<Vector<String>>rows = dataProcess.getData(sql);
		if(rows.size()>0){
			request.setAttribute("mess", "该用户已存在!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request,response);
			return;
		}
		//处理String[]->String
		String strInterest="";
		for(int i=0;i<interests.length;i++){
			strInterest+=interests[i]+", ";
		}
		//如果不为空，则去掉末尾的‘,’
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
