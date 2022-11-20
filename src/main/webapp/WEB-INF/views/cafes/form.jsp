<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<form:form action="/addCafe" modelAttribute="cafe" method="POST">
    <form:input path="id"></form:input>
    <form:input path="name"></form:input>
    <form:input path="address"></form:input>
    <form:errors path="id"></form:errors>
    <form:errors path="name"></form:errors>
    <form:errors path="address"></form:errors>
    <input type="submit"/>
</form:form>
</html>