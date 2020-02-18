<#import "../main/common.ftl" as c>

<@c.page>

    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя сотрудника</label>
            <div class="col-sm-6">
                <input type="text" name="name" value="${people.name!}" class="form-control <#if nameError??>is-invalid</#if>"
                       placeholder="Имя сотрудника" />
                <div class="invalid-feedback">
                    <#if nameError??>
                        ${nameError}
                    </#if>
                </div>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">День рождение:</label>
            <div class="col-sm-6">
                <input type="date" name="birthday"
                       class="form-control <#if birthdayError??>is-invalid</#if>" placeholder="День рождение"
                       value="<#if people.birthday??>${people.birthday?string('yyyy-MM-dd')}</#if>" />
                <div class="invalid-feedback">
                    <#if birthdayError??>
                        ${birthdayError}
                    </#if>
                </div>
            </div>
        </div>
        <button class="btn btn-primary" type="submit"><#if path?contains("edit")>Изменить<#else>Добавить</#if></button>
    </form>

</@c.page>