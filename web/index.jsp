<%-- 
    Document   : index
    Created on : 09/10/2018, 19:31:02
    Author     : Pichau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/4.0.0/default/theme.css" type="text/css"> </head>

    <title>Login </title>
</head>
<body>



    <div class="row">
        <div class="col-md-3"> </div>
        <div class="col-md-6">
            <div class="card text-white p-5 bg-dark">
                <div class="card-body bg-">
                    <h1 class="mb-4">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bem-vindo </h1> 
                    <br>
                    <br>
                    
                    <form action="login" method="POST">
                        <label for="login">Email:</label>
                            <input type="email" name="email" />
                            <label for="senha">Senha:</label>
                            <input type="password" name="senha" />
                            <button type="submit" class="btn btn-primary">LOGAR</button>
                    </form>
                    <br>


                </div>
            </div>
        </div>
    </div>



</body>
</html>
