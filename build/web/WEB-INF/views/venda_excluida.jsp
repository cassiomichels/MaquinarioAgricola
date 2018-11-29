
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>máquinas</title>
       
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>

    
        <div class="container">
             <c:if test="${not empty mensagem}">
            <h2>
                <strong style="color:green";"> ${mensagem}</strong>
            </h2>
       </c:if>
    
       <div class="section">
        <div class="container">
         <div class="row">
           <div class="col-md-12">
             <a class="btn btn-lg btn-success" href="http://localhost:8080/MaquinariosAgricola/busca_venda">Voltar</a>      
        </div>
    </body>
</html>