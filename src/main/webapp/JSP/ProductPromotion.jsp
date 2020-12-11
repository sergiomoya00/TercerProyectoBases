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
         <s:form action="comboProducts" method="post" >
             <s:set var="productName" value="{''}" />
            <s:submit value="Cargar productos" id="btn-submit" align="left"/>
        </s:form>
        <s:form action="addPromo" method="post" >
            <br />
            <s:textfield  size="40" maxlength="40" required="true" key="Nombre de la promoción" name="promo.name"/>
            <s:textfield  size="40" maxlength="40" required="true" key="Descripción" name="promo.description"/>
            <s:textfield  size="40" maxlength="40" required="true" key="Fecha de inicio" name="promo.initialDate"/>
            <s:textfield  size="40" maxlength="40" required="true" key="Fecha de fin" name="promo.finalDate"/>
            <br />
           
            <s:select label="Nombre del producto" name="promo.itemName"
                      accesskey="" headerKey="-1" 
                      cssClass="" list="%{productName}"/>
            <br />          
            <s:set var="type" value="{'regalia','descuento'}" />
            <s:select label="Tipo de descuento" name="promo.discount"
                      accesskey="" headerKey="-1"
                      cssClass="" list="type"/>
            <br />  
            <s:textfield  size="40" maxlength="40" required="true" key="Ingrese descripción o porcentaje" name="promo.regist"/>
            <s:submit value="Registrar" id="btn-submit" align="left"/>
        </s:form>
    </body>
</html>
