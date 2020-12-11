<%-- 
    Document   : AddProduct
    Created on : 05/12/2020, 08:51:00 PM
    Author     : HP ZBOOK 15 G3 i7
--%>

<%@page import="com.operations.action.SelectAction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir artículo</title>
    </head>
    <body>
        <h2 >
            AÑADIR ARTÍCULO
        </h2> 
        <s:form action="addSport" namespace="/">
            <s:textfield label="Deportes para los que se puede utilizar" name="item.sport"></s:textfield>
            <s:submit value="Insertar deporte"></s:submit>
        </s:form>

        <s:form action="addImage" namespace="/">
            <s:textfield label="Imagen del artículo" name="treatments.type"></s:textfield>
            <s:submit value="Insertar imagen"></s:submit>
        </s:form>
        <s:form action="addProduct" method="post" >
            <br />
            <s:textfield  size="40" maxlength="40" required="true" key="Ingresar nombre del artículo" name="item.name"/>
            <s:textfield  size="40" maxlength="40" required="true" key="Ingresar la marca del artículo" name="item.brand"/>
            <s:textfield  size="40" maxlength="40" required="true" key="Ingresar precio del artículo" name="item.price"/>
            <s:textfield  size="40" maxlength="40" required="true" key="Unidades disponibles en inventario" name="item.availableItems"/>
            <br />
            <s:set var="state" value="{'si','no'}" />
            <s:select label="Edición limitada" name="item.limitedEdition"
                      accesskey="" headerKey="-1" 
                      cssClass="" list="%{state}"/>
            <br />          
            <s:set var="type" value="{'prenda','articulo'}" />
            <s:select label="Tipo de producto" name="item.type"
                      accesskey="" headerKey="-1"
                      cssClass="" list="type"/>
            <s:submit value="Registrar" id="btn-submit" align="left"/>
        </s:form>

    </body>
</html>
