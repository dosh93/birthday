
//Поиск клиентов
$("#searchPeople").on("keyup",function(){
    $("tbody").remove();
    $.ajax({
        url: '/search-people?query=' + $("#searchPeople").val() + '&birthday=' + $("#isBirthday").val(),
        cache: false,
        success: function(data){
            $("table").append(data);
        }
    })
});

$("tr.table-danger").on("click", function () {
   var id = $(this).attr("id").split("-")[1];
   $("#givePeople-" + id).attr('checked', true);
});
