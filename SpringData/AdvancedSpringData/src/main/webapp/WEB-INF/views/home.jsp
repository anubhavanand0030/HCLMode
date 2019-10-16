<%@page import="com.hcl.SpringData.EmployController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<script type="text/javascript">
    function goToNewPage()
    {
        var url = document.getElementById('list').value;
        if(url != 'none') {
            window.location = url;
        }
    }
    
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Management Screen</title>
</head>
<body onload="myFunction()">
	<div align="center">
		<h1>Employee List</h1>
		<% int size=(int)request.getAttribute("totalRecords"); 
		int pagesize=(int)request.getAttribute("pagesize");
			int loop;
			if(size%pagesize>0){
				loop=size/pagesize+1;
			} else{
				loop=size/pagesize;
			}
		%>
		<form method="post">
		<select name="list" id="list">
		<%
			for(int i=0;i<loop;i++)
			{	
				out.println("<option");
				out.println(" value='/displayAll/Page/" + i + "' >Page "+i);
				out.println("</option>");
			}
		%>
		
		</select>
		<input type=button value="Go" onclick="goToNewPage()"/>
		</form>
		
		
		<table border="1">

			
			<th>Name</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Basic</th>

			<c:forEach var="emp" items="${employeeList}">
				<tr>

				
					<td>${emp.name}</td>
					<td>${emp.dept}</td>
					<td>${emp.desig}</td>
					<td>${emp.basic}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- <a href="displayJavaContractors">Display Java Contractors</a><br/>
		<a href="displayDotnetDeveloperBasicHigh">Display Dotnet Developer with high salary</a><br/>
		<a href="displayBySalaryAndStartA">Display Having Salary<50000 and Starting with A</a><br/>
		<a href="displayAllSortByDesig">Display all sorted by desig</a><br/>
		<a href="displayAllSortByDesigDesc">Display all sorted by desig descending</a><br/>
		<a href="displayAllSortBySalaryAndDesigDesc">Display all sorted by salary and desig descending</a><br/>	
		<a href="displayByDeptDesigSalSort">Display by dept desig salary sort desc</a><br/>		 -->
			
	</div>
</body>
</html>