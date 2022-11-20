<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cafe List</title>
</head>
<body>

<c:forEach items="${cafes}" var="cafes">
    <h3>Cafe ${cafes.id} ${cafes.address} <a href="/cakes?cafe=${cafes.id}"> Go to ${cafes.name} </a></h3>
</c:forEach>

</body>
</html>