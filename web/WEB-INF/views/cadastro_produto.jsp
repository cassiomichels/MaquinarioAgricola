<%-- 
    Document   : index
    Created on : 09/10/2018, 19:31:02
    Author     : Pichau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/4.0.0/default/theme.css" type="text/css"> </head>

    <title>Cadastrar Produto</title>
</head>
<body>



    <div class="row">
        <div class="col-md-3"> </div>
        <div class="col-md-6">
            <div class="card text-white p-5 bg-dark">
                <div class="card-body bg-">
                    <h1 class="mb-4">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cadastrar Produto
                        <br>
                        <br> </h1>
                    <form method="post" action="cadastro_produto">
                        <div class="form-group">
                            <label for="nome">Nome:</label>
                            <input type="text" class="form-control" placeholder="Digite o nome da máquina agrícula a ser cadastrada"  name="nome"> </div>
                        <div class="form-group">
                            <label for="nome">Descrição do produto: </label>
                            <input type="text" class="form-control" placeholder="Digite uma breve descrição do produto"  name="descricao"> </div> 

                        <button type="submit" class="btn btn-primary"  value="Enviar">Cadastrar</button>

                </div>
            </div>
        </div>
    </div>


</form>
</body>
</html>
