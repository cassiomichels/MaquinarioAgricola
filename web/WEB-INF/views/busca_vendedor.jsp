
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>Gerente</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>


        <div class="container">
            <h1>Vendedores Cadastrados</h1><br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>                        
                        <th>Nome</th>
                        <th>E-mail</th>



                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${gerentes}" var="gerente">
                        <tr>
                            <td><c:out value="${gerente.id}"/></td>
                            <td><c:out value="${gerente.nome}"/></td>
                            <td><c:out value="${gerente.email}"/></td> <br /></td>                        
                        </tr>                        
                    </c:forEach>          
                </tbody>						
            </table>					        
        </div>
    </body>
</html>