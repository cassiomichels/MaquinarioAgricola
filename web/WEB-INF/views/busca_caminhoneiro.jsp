
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>caminhoneiro</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>


        <div class="container">
            <h1>Lista de nossos caminhoneiros</h1><br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>                        
                        <th>Nome</th>
                        <th>E-mail</th>
                        <th>Placa</th>  
                        <th>Opções</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${caminhoneiros}" var="caminhoneiro">
                        <tr>
                            <td><c:out value="${caminhoneiro.id}"/></td>
                            <td><c:out value="${caminhoneiro.nome}"/></td>
                            <td><c:out value="${caminhoneiro.email}"/></td>
                           
                            <td><c:out value="${caminhoneiro.placa}"/> <br /></td> 
                            <td class="text-center">
                          <a href="http://localhost:8080/MaquinariosAgricola/deletar_caminhoneiro?id=${caminhoneiro.id}"  class="btn btn-danger btn-lg">Deletar</a>
                      </td>
                        </tr>                        
                    </c:forEach>          
                </tbody>						
            </table>					        
        </div>
    </body>
</html>