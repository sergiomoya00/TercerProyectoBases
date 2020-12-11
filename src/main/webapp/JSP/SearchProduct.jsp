<%-- 
    Document   : SearchProduct
    Created on : 05/12/2020, 11:14:52 PM
    Author     : HP ZBOOK 15 G3 i7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar producto</title>
    </head>
    <body>
        <h1>BUSCAR UN PRODUCTO ESPECÍFICO</h1>
        <s:form action="productlist" method="post"> 
             <s:textfield label="Nombre del producto" name="item.name"></s:textfield>
              <s:submit value="Mostrar"></s:submit>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Nombre del producto</th>
                            <th scope="col">Marca</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Edicion Limitada</th>
                            <th scope="col">Unidades disponibles</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Deportes</th>

                        </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="list" status="row">
                        <tr>
                            <th scope="row"><s:property value="name"></s:property></th>
                            <td><s:property value="brand"></s:property></td>
                            <td><s:property value="price"></s:property></td>
                            <td><s:property value="limitedEdition"></s:property></td>
                            <td><s:property value="availableItems"></s:property></td>
                            <td><s:property value="type"></s:property></td>
                            <td><s:property value="depor"></s:property></td>


                            </tr>
                    </s:iterator>
                </tbody>
            </table>

        </s:form>
    </body>
</html>
