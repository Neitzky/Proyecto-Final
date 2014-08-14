<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Bienvenidos :3</h1>
        <input type="text" id="nombre" />
        <input type="text" id="sueldo" />
        <input type="button" value="guardar usuario" id="boton-guardar">
        <input type="button" id="mostrar_todos" value="mostrar todos">
       
        <select name="nombres" id="todos" hidden>
             
            </select>
       
        <script>
        
       $("#mostrar_todos").click(function(){ 
        $("#todos").show();/* Este hace que se vea la chingadera de menu */   
        $("#todos").empty(); /* con esta funcion empty vaciamos todo, si  no se te juntaran un chingo de registros en el select de html */   
  $.getJSON("http://localhost:8090/Project/servicios/usuario",function(result){
    $.each(result, function(i, campo){
      $("#todos").append("<option>"+'nombre:'+campo.nombre + '&nbsp'+ 'sueldo:'+campo.sueldo +"</option> ");
    });
  });
});

$("#boton-guardar").click(function(){
    var nombre=$("#nombre").val();
    var sueldo=$("#sueldo").val();
                $.ajax({
        method:'GET',
        url:"http://localhost:8090/Project/servicios/usuario/"+nombre+"/"+sueldo,
        success:function(valor){
            alert(valor);
        },
        failure:function(e){
            alert(e);
        }
    });
});



        </script>
      
        <div></div>
    </body>
</html>