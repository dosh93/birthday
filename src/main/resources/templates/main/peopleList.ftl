<tbody>
<#list peopleList as people>
    <tr>
        <td>${people.name}</td>
        <td>${people.birthday?date?string('MMM dd')}</td>
        <td>
            <form action="/people/delete/${people.id}" method="post">
                <div class="btn-group" role="group" aria-label="Basic example">
                    <button type="submit" class="btn btn-danger btn-sm" role="button"><i class="fas fa-trash"></i></button>
                    <a href="/people/${people.id}/edit" class="btn btn-success btn-sm" role="button"><i class="fas fa-edit"></i></a>
                </div>
            </form>
        </td>
    </tr>
</#list>
</tbody>