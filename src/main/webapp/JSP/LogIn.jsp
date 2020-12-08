<%-- 
    Document   : LogIn
    Created on : 25-jul-2020, 20:42:46
    Author     : jabre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
    </head>
    <body>
        <h1>Ingreso al sistema</h1>
        <s:form action="login" method = "post">
        <s:textfield label="Ingresar el nombre de usuario" name="login.user"></s:textfield>
        <s:password label="Contraseña" name="login.user"></s:password>
        <s:submit value="Ingresar"></s:submit>
        </s:form>
    </body>
</html>
