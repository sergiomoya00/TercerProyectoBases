<%-- 
    Document   : ProductsView
    Created on : 05/12/2020, 11:11:45 PM
    Author     : HP ZBOOK 15 G3 i7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver todos los productos adquiridos</title>
    </head>
    <body>
        <h1>VER PRODUCTOS ADQUIRIDOS</h1>
        <s:form action="userlist" method="post"> 
              <s:submit value="Mostrar"></s:submit>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Nombre del artículo</th>
                            <th scope="col">Cantidad total</th>
                            

                        </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="list" status="row">
                        <tr>
                            <th scope="row"><s:property value="name"></s:property></th>
                            <td><s:property value="country"></s:property></td>
                            <td><s:property value="languages"></s:property></td>


                            </tr>
                    </s:iterator>
                </tbody>
            </table>

        </s:form>
    </body>
</html>
