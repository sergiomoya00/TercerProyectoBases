<%-- 
    Document   : ProductPromotion
    Created on : 05/12/2020, 10:45:34 PM
    Author     : HP ZBOOK 15 G3 i7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>+
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar promoción</title>
    </head>
    <body>
        <h2 >
            CREAR PROMOCIÓN
        </h2> 
        <s:form action="addProduct" method="post" >
            <br />
            <s:textfield  size="40" maxlength="40" required="true" key="Nombre de la promoción" name="treatments.name"/>
            <s:textfield  size="40" maxlength="40" required="true" key="Descripción" name="treatment.name"/>
            <s:textfield  size="40" maxlength="40" required="true" key="Fecha de inicio" name="treatmen.name"/>
            <s:textfield  size="40" maxlength="40" required="true" key="Fecha de fin" name="tretments.name"/>
            <br />
            <s:set var="productName" value="{'si','no'}" />
            <s:select label="Nombre del producto" name="yourProduct"
                      accesskey="" headerKey="-1" 
                      cssClass="" list="productName"/>
            <br />          
            <s:set var="type" value="{'regalia','descuento'}" />
            <s:select label="Tipo de descuento" name="yourType"
                      accesskey="" headerKey="-1"
                      cssClass="" list="type"/>
            <br />  
            <s:textfield  size="40" maxlength="40" required="true" key="Ingrese descripción o porcentaje" name="tretments.name"/>
            <s:submit value="Registrar" id="btn-submit" align="left"/>
        </s:form>
    </body>
</html>
