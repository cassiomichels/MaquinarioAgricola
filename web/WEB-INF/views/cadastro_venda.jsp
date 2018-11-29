<%-- 
    Document   : index
    Created on : 09/10/2018, 19:31:02
    Author     : Pichau
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/4.0.0/default/theme.css" type="text/css"> </head>

    <title>Cadastrar Pedido</title>
</head>
<body>



    <div class="row">
        <div class="col-md-3"> </div>
        <div class="col-md-6">
            <div class="card text-white p-5 bg-dark">
                <div class="card-body bg-">
                    <h1 class="mb-4">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cadastrar Venda
                        <br>
                        <br> </h1>
                    <form action="cadastro_venda" method="POST">
                        <div class="form-group">
                            <label for="idCliente">Cliente:</label>
                            <select class="custom-select" name="id_cliente">                
                                <option selected>Selecione um cliente abaixo</option>
                                <c:forEach items="${clientes}" var="cliente">                                  
                                    <option value="<c:out value="${cliente.id}"/>">
                                        <c:out value="${cliente.id}${' - '}${cliente.nome}"/></option>'
                                    </c:forEach> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idFuncionario">Caminhoneiro:</label>
                            <select class="custom-select" name="id_caminhoneiro">                
                                <option selected>Selecione um caminhoneiro abaixo</option>
                                <c:forEach items="${caminhoneiros}" var="caminhoneiro">                                  
                                    <option value="<c:out value="${caminhoneiro.id}"/>">
                                        <c:out value="${caminhoneiro.id}${' - '}${caminhoneiro.nome}"/></option>'
                                    </c:forEach> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idVeiculo">Maquina :</label>
                            <select class="custom-select" name="id_produto">                
                                <option selected>Selecione uma maquina abaixo</option>
                                <c:forEach items="${produtos}" var="produto">                                  
                                    <option value="<c:out value="${produto.id}"/>">
                                        <c:out value="${produto.id}${' - '}${produto.nome}${' - '}${produto.descricao}"/></option>'
                                    </c:forEach> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="nome">Endereço:</label>
                            <input type="text" class="form-control" placeholder="Digite o endereço de entrega"  name="endereco"> </div>

                        <button type="submit" value="Enviar" class="btn btn-primary">Cadastrar</button>
                    </form>
                    </body>
                    </html>
