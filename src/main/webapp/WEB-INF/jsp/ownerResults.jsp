<%--
  Created by IntelliJ IDEA.
  User: hyardimci
  Date: 5/11/13
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<c:forEach items="${owners}" var="o">
    ${o.id}  ${o.firstName}  ${o.lastName} <br/>
</c:forEach>

</body>
</html>