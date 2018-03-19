<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<script>
function openWin(url,width,height){
var phxWin=window.open(url, '', 'width='+width+',height='+height+',left='+(screen.width-width)/2+',top='+(screen.height-height)/2+'');
}
</script>
	
	<div id="logo">
		<a href="#"><img src="images/logo.png" border= "0 "/></a>
	</div>
	
	<div id="header_right">
		<%
			String userName = null;
      		if(session.getAttribute("user") != null)
      			userName = session.getAttribute("user").toString();
      		if(userName == null){
      	%>
				欢迎光临，<a href="reg.jsp">注册</a>/<a href="login.jsp">登陆</a>
		<%
      		}else{
      			byte a[]=userName.getBytes("ISO-8859-1");
      			userName=new String(a);
      			out.print(""+userName+"，<span style='color:red'>欢迎光临!</span>");
      		}
      	%>
		
		<br>
		<img src="images/chat.png" />&nbsp;<a onClick="openWin('contact.jsp',300,200)" style="cursor:hand" >联系我们</a> <img src="images/order.png" />&nbsp;<a href="ShowCartServlet">购物车</a>
	</div>

	<div id="headermenu">

		<ul id="menu">
		<li>
			<a class="li" href="index.jsp"><img src="images/dh_1.png" border= "0 "/>&nbsp首页</a>
		</li>
		<li>
			<a class="li" href="#" ><img src="images/dh_2.png" border= "0 "/>&nbsp商店公告</a>
		</li>
		
		<li>
			<a class="li" href="ShowProductServlet?nowPage=1" ><img src="images/dh_3.png" border= "0 "/>&nbsp全部商品</a>
		</li>
		
		<li>
			<a class="li" href="#" ><img src="images/dh_4.png" border= "0 "/>&nbsp付款方式</a>
		</li>
		
		<li>
			<a class="li" href="#"><img src="images/dh_5.png" border= "0 "/>&nbsp关于我们</a>
		</li>
		
		<li>
			<a class="li" href="#" ><img src="images/dh_6.png" border= "0 "/>&nbsp在线留言</a>
		</li>
		

		</ul>
	</div>
	
	<div id="search">
		<form id="form1" name="search" method="post" action="#">
			<input type="text" name="textfield" style="color:#a4a4a4;vertical-align:middle;" value="请输入关键字"  onfocus="this.value=''" />&nbsp
			<input name="imageField" type="image" align="absmiddle" src="images/search.gif" />
		</form>
	</div>