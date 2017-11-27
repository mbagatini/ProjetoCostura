/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function configuraRelatorios(titulo, subtitulo, colunas) {

    $("#example1").DataTable({
        "order": [[0, "asc"]],
        dom: 'Bfrtip',
        buttons: [
            {
                extend: 'copy',
                exportOptions: {
                    columns: [colunas]
                }
            },
            {
                extend: 'csv',
                title: titulo,
                exportOptions: {
                    columns: [colunas]
                }
            },
            {
                extend: 'excel',
                title: titulo,
                messageTop: subtitulo,
                exportOptions: {
                    columns: [colunas]
                }
            },
            {
                extend: 'pdf',
                title: titulo,
                messageTop: subtitulo,
                exportOptions: {
                    columns: [colunas]
                }
            },
            {
                extend: 'print',
                title: titulo,
                messageTop: subtitulo,
                exportOptions: {
                    columns: [colunas]
                }
            }
        ]
    });
    
    $('#example2').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false
    });
}