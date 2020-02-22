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
        </tr>
        </thead>
        <#include "main/peopleList.ftl">
    </table>
    <br>


    <div class="row">
        <div class="col-sm-6 my-1">
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-text">Кто сдает</div>
                </div>
                <select  name="people_selected" id="people_selected" class="selectpicker form-control" data-live-search="true"
                         title="Выберете сотрудника">
                    <#include "main/optionalPeople.ftl">
                </select>
            </div>
        </div>
        <div class="col-sm-6 my-1">
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-text">сколько</div>
                </div>
                <input type="text" class="form-control" id="money" placeholder="Сколько">
                <div class="input-group-append">
                    <div class="input-group-text"><i class="fas fa-ruble-sign"></i></div>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <button type="button" id="sendMoney" class="btn btn-primary btn-lg btn-block">Сдать</button>
        </div>
    </div>
    <input type="hidden" name="hidden_people_selected" id="hidden_people_selected" />
</@c.page>