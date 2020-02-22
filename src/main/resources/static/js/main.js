
//Поиск клиентов
$("#searchPeople").on("keyup",function(){
    var url = '/search-people?query=' + $("#searchPeople").val() + '&birthday=' + $("#isBirthday").val();
    $("input[name='givePeople']:checked").each(function () {
        url += "&givePeople=" + $(this).attr("id").split("-")[1];
    });
    $("tbody").remove();
    $.ajax({
        url: url,
        cache: false,
        success: function(data){
            $("table").append(data);
        }
    })
});

$("table").on("click", "tr.linePeople", function () {
   var id = $(this).attr("id").split("-")[1];
   $("#givePeople-" + id).attr('checked', $("#givePeople-" + id).attr("checked") == "checked" ? false : true);
});

$('select').selectpicker();

$('#people_selected').change(function(){
    $('#hidden_people_selected').val($('#people_selected').val());
});

$('#sendMoney').on("click", function () {
   var url = "/sendMoneyAll?who=" + $('#hidden_people_selected').val() + "&money=" + $('#money').val();
    $("input[name='givePeople']:checked").each(function () {
        url += "&givePeople=" + $(this).attr("id").split("-")[1];
    });
    $.ajax({
        url: url,
        cache: false,
        success: function(data){
            $(".alert").remove();
            $("#successesMessage").append(data);
            $('#hidden_people_selected').val('')
            $('#money').val('')
            $("input[name='givePeople']:checked").each(function () {
                $(this).attr('checked',false);
            });
            $("button[data-id='people_selected']").attr('title','');
        }
    })
});