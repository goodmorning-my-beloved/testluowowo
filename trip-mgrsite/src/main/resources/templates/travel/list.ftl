<html lang="en">
<head>
    <title>游记管理</title>
    <#include "../common/header.ftl">
    <script type="text/javascript">
        $(function () {

        })
    </script>
</head>
<body>
<!--左侧菜单回显变量设置-->
<#assign currentMenu="travel">

<div class="container-fluid " style="margin-top: 20px">
    <#include "../common/top.ftl">
    <div class="row">
        <div class="col-sm-2">
            <#include "../common/menu.ftl">
        </div>
        <div class="col-sm-10">
            <div class="row">
                <div class="col-sm-12">
                    <h1 class="page-head-line">游记管理</h1>
                </div>
            </div>
            <#setting number_format="#">
            <!--高级查询--->
            <form class="form-inline" id="searchForm" action="/travel/list" method="post">
                <input type="hidden" name="currentPage" id="currentPage" value="1">
                <div class="form-group">
                    <label for="keyword">关键字:</label>
                    <input type="text" class="form-control" id="keyword" name="keyword" value="${(qo.keyword)!''}" placeholder="请输入名称">
                </div>
                <div class="form-group">
                    <label for="state">状态:</label>
                    <select class="form-control" id="ishot" name="ishot">
                        <option value="-1">全部</option>
                        <option value="0">草稿</option>
                        <option value="1">待发布</option>
                        <option value="2">发布</option>
                        <option value="3">拒绝</option>
                    </select>
                </div>
                <a href="/strategyDetail/input" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>  查询</a>
            </form>

            <table class="table table-striped table-hover" >
                <thead>
                    <tr>
                        <th>编号</th>
                        <th>标题</th>
                        <th>封面</th>
                        <th>地点</th>
                        <th>作者</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
               <#list pageInfo.list as entity>
                   <tr>
                       <td>${entity_index+1}</td>
                       <td>${entity.title!}</td>
                       <td><img src="${entity.coverUrl!}" width="100px"> </td>
                       <td>${(entity.dest.name)!}</td>
                       <td>${(entity.author.nickname)!}</td>
                       <td>${entity.stateDisplay!}</td>
                       <td>

                           <#if  entity.state == 1>
                            <a class="btn btn-danger btn-xs changeStateBtn" href="javascript:;" data-state='0' data-id="${entity.id}">
                                <span class="glyphicon glyphicon-minus-sign"></span> 下架
                            </a>

                           <#else>
                            <a class="btn btn-default btn-xs changeStateBtn" href="JavaScript:;" data-state="1" data-id="${entity.id}">
                                <span class="glyphicon glyphicon-tag"></span> 发布
                            </a>
                           </#if>

                           <a class="btn btn-info btn-xs inputBtn" href="/strategyDetail/input?id=${entity.id}">
                               <span class="glyphicon glyphicon-edit"></span> 查看
                           </a>

                       </td>
                   </tr>
               </#list>
            </table>
            <#--分页-->
            <#include "../common/page.ftl"/>
        </div>
    </div>
</div>

</body>
</html>