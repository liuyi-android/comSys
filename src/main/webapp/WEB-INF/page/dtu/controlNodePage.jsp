<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/dtuPage.js?ran=<%=Math.random()%>"></script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<h3 style="margin-left: 30px;margin-top: 30px;">控制节点信息（${dtuInfo.dtu_name}）</h3>
<hr/>
<div style="width: 98%;float: left;margin-left: 20px;margin-right:10px;background-color:  #c2e8ef;">
    <%--<ul class="nav nav-tabs nav-justified">--%>
    <!--导航菜单...-->
    <ul class="nav nav-pills nav-justified">
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=6">数据显示</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=1">DTU信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=2">传感器节点信息</a></li>
        <li role="presentation" class="active"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=3">控制节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=4">报警信息</a></li>
       <%-- <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=5">分组信息</a></li>--%>

    </ul>
    <!--导航菜单...-->
</div>
<div class="container con_title" style="margin-top: 100px;" >
    <div style="margin-left: 30px;margin-top: 10px;margin-bottom: 10px; ">
        <button type="button" style="" class="btn btn-primary" onclick="add();" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;
    </div>
    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
        <thead class="text-center">
        <tr class="" style="background-color: #3278f7;color: white;">
            <td>序号</td>
            <td>控制器名称</td>
            <td>控制器类型码</td>
            <td>控制器地址</td>
            <td>控制器描述</td>
            <td>控制器站内坐标X</td>
            <td>控制器站内坐标Y</td>
            <td>控制器任务数</td>
            <td>通道描述</td>
        </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach var="controlNode" items="${ctrlNodeInfo.result}" varStatus="status">
            <c:if test="${(status.index+1)%2 == 1}">
            <tr class="info">
                <td>${ststus.index+1}</td>
                <td>${controlNode.name}</td>
                <td>${controlNode.cfg}</td>
                <td>${controlNode.addr}</td>
                <td>${controlNode.describ}</td>
                <td>${controlNode.x}</td>
                <td>${controlNode.y}</td>
                <td>${controlNode.tsknum}</td>
                <td>
                    <table>
                        <c:forEach var="desc" items="${controlNode.tskdescrib}" >
                            <tr class="info"><td>${desc.tsk_describ}</td></tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            </c:if>
            <c:if test="${(status.index+1)%2 == 0}">
                <tr class="active">
                <td>${ststus.index+1}</td>
                <td>${controlNode.name}</td>
                <td>${controlNode.cfg}</td>
                <td>${controlNode.addr}</td>
                <td>${controlNode.describ}</td>
                <td>${controlNode.x}</td>
                <td>${controlNode.y}</td>
                <td>${controlNode.tsknum}</td>
                    <td>
                        <table>
                            <c:forEach var="desc" items="${controlNode.tskdescrib}" >
                                <tr class="active"><td>${desc.tsk_describ}</td></tr>
                            </c:forEach>
                        </table>
                    </td>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>