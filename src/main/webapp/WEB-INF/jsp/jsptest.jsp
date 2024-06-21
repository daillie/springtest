<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Index</title>        
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Number:</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${kek}" var="number">
                    <tr>
                        <td>${number}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>