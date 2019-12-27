<#list toasts as t>
>> ${t.id}  ${t.name}
</#list>
地点:${theSearchDest.name}
下级地区:
<#list subordinateDests as t>
    ${t.name}
</#list>