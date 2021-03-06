
<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">User list</a> </span>
</div>
<div>
    <form method="post">
        <input type="text" name="text" placeholder="Введите сообщение" />
        <input type="text" name="teg" placeholder="Тэг">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>

<#list messages as message>
<div>
    <b> ${message.id!'null'} </b>
    <span>  ${message.text} </span>
    <i>  ${message.teg} </i>
    <strong> ${message.authorName} </strong>
</div>
<#else>
No message
</#list>
</@c.page>