<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Vector" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱尚网扇品</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	
	<div id="page">
		<div id="header">
			<jsp:include page="header.jsp" />      
       	</div>
			
		<div id="left_column">
			<jsp:include page="left_column.jsp" />  
		</div>
			
		<div id="center_column">		
			<div class="divBorder">
			<%
				String sortid = request.getParameter("sortid");
			if(sortid==null){
				%>
				<img src="images/all_fans.gif" /><br>
				<%
			}
			else if(sortid.equals("1")){
				%>
				<img src="images/woman_fans.gif" /><br>
				<%
			}
			else if(sortid.equals("2")){
				%>
				<img src="images/man_fans.gif" /><br>
				<%
			}
			else if(sortid.equals("3")){
				%>
				<img src="images/korea_fans.gif" /><br>
				<%
			}
			else if(sortid.equals("4")){
				%>
				<img src="images/wood_fans.gif" /><br>
				<%
			}
			else if(sortid.equals("5")){
				%>
				<img src="images/gift_fans.gif" /><br>
				<%
			}
			else{
				%>
				<img src="images/all_fans.gif" /><br>
				<%
			}
				%>
				<%!
				int pageSize = 9; //每页放九张图
				int pageNum; //总页数 
				int nowPage; //当前页
				int firstPosition; //每页的第一个位置
				%>
				<%
				Vector<Vector<String>> sortProduct = (Vector<Vector<String>>)request.getAttribute("sortProduct");
				if(sortProduct == null){
					response.sendRedirect("SortProductServlet");
					return;
				}
				if(sortProduct.size() % pageSize == 0){
					pageNum = sortProduct.size() / pageSize;
				}
				else{
					pageNum = sortProduct.size() / pageSize + 1;
				}
				String nowNum = request.getParameter("nowPage");
				if(nowNum==null){
					nowNum = "1";
				}
				nowPage = Integer.parseInt(nowNum);
				if(nowPage > pageNum || nowPage < 1){
					nowPage = 1;
				}
				firstPosition = (nowPage-1) * pageSize;
				for(int i=firstPosition; i<firstPosition+pageSize; i++){
				  if(i<sortProduct.size()){
					Vector oneProduct=sortProduct.get(i); //获取一条记录
				%>
					<div id='sort_product'>
					 <ul>
						<li><p class='gpic'><a href="ShowProDetailServlet?id=<%=oneProduct.get(0) %>"><img width='205' height='154' src="<%=oneProduct.get(3)%>"></a></p></li> 
						<li><p class='gbt'><a href="ShowProDetailServlet?id=<%=oneProduct.get(0) %>">品名：<%=oneProduct.get(1) %> </a></p></li>
						<li><p class='gprice'>促销价：<span style="color:#FF6600;font-weight:bold;"></span>￥<%=oneProduct.get(2) %></p></li>
						<li><p class='gsale'>已售出：<span style='font-weight:bold;'><%=oneProduct.get(4) %></span>&nbsp;笔</p></li>
					 </ul>
					</div>
				<% 	
				  }
				}
				%>
			
				<div id='page_next'>
					<a class="pageLink" href="SortProductServlet?sortid=<%=sortid %>&nowPage=<%=nowPage-1 %>">上一页</a>&nbsp;
					第<%=nowPage %>页
					<%if(nowPage==pageNum){nowPage=0;} %>
					<a class="pageLink" href="SortProductServlet?sortid=<%=sortid %>&nowPage=<%=nowPage+1 %>">下一页</a>&nbsp;
				</div>  
			</div>
		</div>			
		<div id="footer">
			<jsp:include page="bottom.jsp" />  
		</div>
		
	</div>
</body>
</html>