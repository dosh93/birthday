<#import "../main/common.ftl" as c>

<@c.page>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">День Рождение</th>
            <th scope="col">Действия</th>
        </tr>
        </thead>
        <tbody>
        <#list peopleList as people>
            <tr>
                <td>${people.name}</td>
                <td>${people.birthday?date}</td>
                <td><a href="/people/delete/${people.id}" type="button" class="btn btn-danger btn-sm"><i class="fas fa-trash"></i></a></td>
            </tr>
        </#list>

        </tbody>
    </table>
</@c.page>