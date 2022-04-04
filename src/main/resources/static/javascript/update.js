$(document).ready(function (){
    $(".main-form").on("submit", function (ev){
        var data, nome, cpf, sexo;

        ev.preventDefault();
        nome = $("#nome").val();
        cpf = $("#cpf").val();
        sexo = $("#sexo").val();

        data = {
            nome:nome,
            cpf:cpf,
            sexo:sexo
        };

        $.ajax({
            url:"/pessoa/atualizar",
            method:"PUT",
            data:data,
            success: function (response){
                alert("Atualizado com sucesso!");
                window.location.href = "/";
            },
            error: function () {
                alert("Houve algum erro!")
            }
        });
    });
});