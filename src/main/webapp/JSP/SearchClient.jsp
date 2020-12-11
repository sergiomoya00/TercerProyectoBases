<%-- 
    Document   : SearchClient
    Created on : 05/12/2020, 11:04:01 PM
    Author     : HP ZBOOK 15 G3 i7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar cliente</title>
    </head>
    <body>
        <h1>BUSCAR CLIENTE EN PARTICULAR</h1>
        <s:form action="userlist" method="post"> 
             <s:textfield label="Nombre real o nombre de usuario" name="treatments.type"></s:textfield>
              <s:submit value="Mostrar"></s:submit>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Nombre de cliente</th>
                            <th scope="col">Articulo</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Cantidad</th>

                        </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="list" status="row">
                        <tr>
                            <th scope="row"><s:property value="name"></s:property></th>
                            <td><s:property value="country"></s:property></td>
                            <td><img src="<s:url value='/JSP/img/portfolio-1.jpg'/>" /></td>


                            </tr>
                    </s:iterator>
                </tbody>
            </table>

        </s:form>


    </body>
</html>
