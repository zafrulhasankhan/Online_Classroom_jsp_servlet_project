<%-- 
    Document   : viewImage
    Created on : May 9, 2020, 1:40:22 AM
    Author     : Zafrul Hasan Nasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>View Image</title>
    </head>
    
    <body>
    
        <b>View | <a href="index.jsp">Upload</a></b><br/><br/>
        
		<%
		String id = request.getParameter("name");
		%>
		<img src="getImage.jsp?id=<%=id%>" width="400px"/>
 
    </body>
</html>



