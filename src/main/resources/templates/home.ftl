<#import "main/common.ftl" as c>

<@c.page>

    <#include "main/searchPeople.ftl">
    <input hidden id="isBirthday" value="true">
    <br>
    <table class="table table-hover" id="tablePeople">
        <thead>
        <tr>
            <th scope="col">Сдать</th>
            <th scope="col">Имя</th>
            <th scope="col">День Рождение</th>
            <th scope="col">Действия</th>
        </tr>
        </thead>
        <#include "main/peopleList.ftl">
    </table>



</@c.page>