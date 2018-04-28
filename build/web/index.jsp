<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="service" class="webshop.ProductsService"  scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Webshop kedvezménykezelés</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <h3>A vásárláshoz kérem válasszon az alábbi termékekből:</h3>
        <form action='order.jsp' method='post'>
            <%= service.getBuyableProducts() %>
        </form>
        
        
    </body>
    
</html>
