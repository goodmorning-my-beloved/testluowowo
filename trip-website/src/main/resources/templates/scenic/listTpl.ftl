<div class="_notelist">
    <div class="post-list">
        <ul class="scenic-list clearfix">
            <#list pageInfo.list as list>
            <li>
                <a href="/scenic/detail?id=${list.id!}" target="_blank" title="${list.name}">
                    <div class="img"><img
                            src="${list.coverUrls[0]}"
                            width="192" height="130"></div>
                    <h3>${list.name}</h3>
                </a>
            </li>
        </#list>
        </ul>
        <br><br>

    </div>
</div>
<#include "../common/page.ftl">