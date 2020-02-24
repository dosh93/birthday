
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
            $("input[name='givePeople']:checked").each(function (index) {
                console.log(index);
                $(this).attr('checked',false);
            });
            $('select').selectpicker('val', '0');
        }
    })
});


("input[aria-label='Search']").on("keyup",function(){

    $.ajax({
        url: "/getOptionPeople?query=" + $("input[aria-label='Search']").val(),
        cache: false,
        success: function(data){
            $("#people_selected").html(data).selectpicker('refresh');
        }
    })
});

