function apresentaEspecialidade() {
    var especialidade = document.getElementById("especialidade");
    var nome = especialidade.value;
    console.log(nome);
}

$(document).ready(function () {

    $('#especialidade').on('change', function () {
        var nome = $(this).value;
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/cliente/listarProfissionalEspecialidade/' + nome,
            success: function (result) {
                //testando qualquer coisa, colocar tabela?
                var s = '<option value="">Selecione</option>';
                for (var i = 0; i < result.length; i++) {
                    s += '<option value="' + result[i].id + '">'
                        + result[i].nome
                        + '</option>';

                }
                $('#especialidade').html(s);
            },
            error: function (request, status, error) {
                alert(request.responseText);
            }
        });
    })

})
