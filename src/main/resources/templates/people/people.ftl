<#import "../main/common.ftl" as c>

<@c.page>
    <#include "../main/searchPeople.ftl">
    <input hidden id="isBirthday" value="false">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">День Рождение</th>
            <th scope="col">Действия</th>
        </tr>
        </thead>
        <#include "../main/peopleList.ftl">
    </table>
    <a href="/people/add-people" class="btn btn-primary">Добавить</a>
</@c.page>