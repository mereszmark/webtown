<%@page pageEncoding="UTF-8"%>
<%@ page import = "java.util.Map" %>
<jsp:useBean id="service" class="webshop.ProductsService"  scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Webshop kedvezménykezelés</title>
    </head>
    <body>

        <%
            request.setCharacterEncoding("UTF-8");
            Map<String, String[]> parameters = request.getParameterMap();
            for (String parameter : parameters.keySet()) {
                if (parameter.toLowerCase().startsWith("quantityof")) {
                    String[] values = parameters.get(parameter);
                    out.print(parameter.substring(10));
                    out.print(values[0]);        
                    service.addProduct(parameter.substring(10), Integer.parseInt(values[0]));
                }
            }
            response.sendRedirect("viewoforder.jsp");
        %>

    </body>
</html>
