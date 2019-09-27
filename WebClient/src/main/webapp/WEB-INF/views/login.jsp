<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
        <h1>Login Page</h1>
        <form:form action="/home" method="post" modelAttribute="user">
        <table>
        <form:hidden path="id"/>
            <tr>
                <td>User Name:</td>
                <td><form:input path="userName" /></td>
               
            </tr>
            <tr>
                <td>Password: </td>
                <td><form:input path="passWord" /></td>
            </tr>
            <tr>
            
                <td colspan="2" align="center"><input type="submit" value="Login"></td>
            </tr>
        </table>
        </form:form>
    </div>

</body>
</html>