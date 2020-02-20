
//Поиск клиентов
$("#searchPeople").on("keyup",function(){
    $("tbody").remove();
    $.ajax({
        url: '/search-people?query=' + $("#searchPeople").val(),
        cache: false,
        success: function(data){
            $("table").append(data);
        }
    })
});
