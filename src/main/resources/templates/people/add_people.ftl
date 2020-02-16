<#import "../main/common.ftl" as c>

<@c.page>
    <form action="/people/add-people" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя сотрудника</label>
            <div class="col-sm-6">
                <input type="text" name="name" value="${people.name}" class="form-control"
                       placeholder="Имя сотрудника" />
                <div class="invalid-feedback"></div>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">День рождение:</label>
            <div class="col-sm-6">
                <input type="date" name="birthday" class="form-control" placeholder="День рождение" value="${people.birthday}" />
                <div class="invalid-feedback"></div>
            </div>
        </div>
        <button class="btn btn-primary" type="submit">Добавить</button>
    </form>
</@c.page>