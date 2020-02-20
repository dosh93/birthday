<#import "../main/common.ftl" as c>

<@c.page>
<form action="/config/update" method="post">
    <#list configList as config>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">${config.name}</label>
            <div class="col-sm-6">
                <input type="text" name="${config.key}" value="${config.value!}" class="form-control" required/>
            </div>
        </div>
    </#list>
    <button class="btn btn-danger" type="submit">Изменить</button>
</form>
</@c.page>