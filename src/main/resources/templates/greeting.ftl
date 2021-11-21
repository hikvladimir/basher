<#import "parts/common.ftl" as c>
<@c.page>
<div>Hello user</div>
<a href="/main">Main page</a>
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