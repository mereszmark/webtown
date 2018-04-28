
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="service" class="webshop.ProductsService"  scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Webshop kedvezménykezelés</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <h3>A leadott rendelés a következő:</h3>
        <%=service.getOrderedProducts()%>
        <%service.clear();%>
    </body>
</html>
