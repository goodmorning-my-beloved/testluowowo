<div class="wrapper">
    <ul class="clearfix">
        <#list pageInfo.list as page>
            <li class="item">
                <div class="img">
                    <a href="javascript:;" target="_blank"><img height="200" width="320" src="${page.coverUrl!}"
                                                                style="display: inline;">
                        <div class="title">${page.dest.name!}</div>
                    </a>
                </div>
                <div class="info">
                    <p class="detail">${page.title!}</p>
                    <div class="hot">
                        <span class="label">TOP3</span>
                        <a href="javascript:;" target="_blank">${page.hottop!}</a>
                        <#--<span class="divide"></span>
                        <a href="javascript:;" target="_blank">库塔海滩</a>
                        <span class="divide"></span>
                        <a href="javascript:;" target="_blank">情人崖</a>-->
                    </div>

                    <div class="line"><a href="javascript:;" target="_blank"><em>1</em>${page.route!}</a></div>
                </div>
            </li>
        </#list>
    </ul>
</div>
<#include "../common/page.ftl">