<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cafe List</title>
</head>
<body>

<c:forEach items="${cakes}" var="cakes">
    <h3>Name: ${cakes.name} Description:${cakes.description} Ingredients:${cakes.ingredients} Amount:${cakes.amount} </h3>
</c:forEach>
<a href="/newCake?cafe=${cafe}"> Add a cake to the cafe </a>

</body>
</html>