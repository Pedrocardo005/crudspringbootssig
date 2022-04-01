$(document).ready(function () {
   function inicial() {
       $.ajax({
           url:"/pessoa",
           success: function (response) {
                response.map(function (item) {
                    var $tr, $td1, $td2, $td3, $del;

                    $tr = $('<tr>');
                    $td1 = $(`<td>${item.nome}</td>`);
                    $td2 = $(`<td>${item.cpf}</td>`);
                    $td3 = $(`<td>${item.sexo}</td>`);
                    $del = $(`<button class="btn btn-danger">Deletar</button>`);

                    $("tbody").append($tr);

                    $tr.append($td1);
                    $tr.append($td2);
                    $tr.append($td3);
                    $tr.append($del);
                });
           },
           error: function (response) {
                console.error(response);
           }
       });
    }
    
    inicial();

    $(".main-form").on("submit", function (event) {
        var nome, cpf, sexo, data;

        event.preventDefault();

        nome = $("#nome").val();
        cpf = $("#cpf").val();
        sexo = $("#sexo").val();

        data = {
            nome: nome,
            cpf: cpf,
            sexo: sexo
        };

        $.ajax({
            url:"/pessoa/cadastrar",
            contentType: "application/json",
            method: "POST",
            data: JSON.stringify(data),
            success: function (response) {
                alert("Inserido com sucesso!");
                $("tbody").empty();
                inicial();
            },
            error: function (response) {
                alert("Erro ao inserir o cliente");
            }
        });
    });
});
