<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>

<head>
	
	<title>
		Customers list
	</title>
	<link type="text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

	List of Customers
	<hr>
	<br><br>
	
	<div id = "wrapper">
		<div id = "header">
			<h2> CRM - Customer Manager</h2>
		</div>
	
	</div>
	<div id = "container">
		<div id = "content">
		
		<!-- Add button for adding new Customer -->
		
		<input type = "button" value = "+  Customer"
				onclick = "window.location.href='showAddForm'; return false;"
				class = "add-button"
				/>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
				<c:forEach var = "tempCustomer" items = "${customers}">
					
					<c:url var = "updateLink" value = "/customer/showUpdateForm">
						<c:param name="customerId" value = "${tempCustomer.id}"/>
					</c:url>
					<tr> 
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						
						<td> 
							<a href = "${updateLink}">Update</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

