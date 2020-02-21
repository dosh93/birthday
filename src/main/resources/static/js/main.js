
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
