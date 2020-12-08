<%-- 
    Document   : BuyProduct
    Created on : 05/12/2020, 11:28:22 PM
    Author     : HP ZBOOK 15 G3 i7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprar producto</title>
    </head>
    <body>
        <h1>Busqueda y compra </h1>

        <s:form action="languageTTRegiste" method="post"> 
            <s:textfield label="Nombre del producto" id="txtvalue" name="languageToTeach.name"></s:textfield>
            <s:submit value="Buscar"></s:submit>
        </s:form>


        <h2>

            <select id="ddselect"  onchange="ddlselect();">
                <option value="0">Categoría</option>

            </select>
        </h2> 



        <s:form action="combo" method="post">
            <s:submit value="Cargar productos relacionados al deporte"></s:submit>
            <s:form>
                <h2>

                    <select id="ddselect"  onchange="ddlselect();">
                        <option value="0">Nombre del producto</option>

                    </select>
                </h2> 

            </s:form>
        </s:form>
        <s:form action="languageTTRegiste" method="post"> 
            <s:textfield label="Cantidad a comprar" id="txtvalue" name="languageToTeach.name"></s:textfield>
            <s:submit value="Comprar"></s:submit>
        </s:form>
        <s:form action="languageTLRegiste" method="post">

            <s:submit value="Añadir al carrito"></s:submit>
        </s:form>
        <s:form action="languageTLRegiste" method="post">

            <s:submit value="Ver carrito"></s:submit>
        </s:form>

    </body>
</html>
