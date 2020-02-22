<tbody>
<#list peopleList as people>

    <tr class="table-<#if (people.countDays < 0)>danger<#elseif (people.countDays > 0)>primary<#else>success</#if> linePeople"
        id="linePeople-${people.id}">

    <#if isGive??>
        <td>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="givePeople-${people.id}" name="givePeople"
                       <#if people.give>checked</#if>>
            </div>
        </td>
    </#if>
    <td>${people.name}</td>
    <td>${people.birthday?date?string('MMM dd')} (до ДР ${people.countDays} дней)</td>
    <#if !isGive??>
        <td>
            <form action="/people/delete/${people.id}" method="post">
                <div class="btn-group" role="group" aria-label="Basic example">
                    <button type="submit" class="btn btn-danger btn-sm" role="button"><i class="fas fa-trash"></i></button>
                    <a href="/people/${people.id}/edit" class="btn btn-success btn-sm" role="button"><i class="fas fa-edit"></i></a>
                </div>
            </form>
        </td>
    </#if>
    </tr>
</#list>
</tbody>
