<%-- 
    Document   : ClientRegister
    Created on : 05/12/2020, 11:19:17 PM
    Author     : HP ZBOOK 15 G3 i7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro del cliente</title>
    </head>
    <body>
        <h1>REGISTRO DEL CLIENTE</h1>
        <s:form action="createtreatments" namespace="/">


            <s:textfield label="Nombre y apellidos" name="treatments.name"  ></s:textfield>
            <s:textfield label="Fecha de nacimiento" name="treatments.quantity"></s:textfield>
            <s:textfield label="Sexo" name="treatments.type"></s:textfield>
            <s:textfield label="Nombre de usuario" name="treatments.type"></s:textfield>
            <s:password label="Contraseña" name="treatments.type"></s:password>


            <s:submit value="Registrar" align="left"></s:submit>
        </s:form>
    </body>
</html>
