<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<body>
<form:form action="/addCake?cafe=${cafe}" modelAttribute="cake" method="POST">
    <form:input path="name"></form:input>
    <form:input path="description"></form:input>
    <form:input path="ingredients"></form:input>
    <form:input path="amount"></form:input>
    <form:errors path="name"></form:errors>
    <form:errors path="description"></form:errors>
    <form:errors path="ingredients"></form:errors>
    <form:errors path="amount"></form:errors>
    <input type="submit"/>
</form:form>
</body>
</html>