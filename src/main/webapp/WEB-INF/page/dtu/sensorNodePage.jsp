<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath }common/myjs/sensorNodePage.js?ran=<%=Math.random()%>"></script>
</head>
<body style="font-family: '微软雅黑';">
<input id="basePath" value="${basePath }" type="hidden">
<input id="dtu_sn" value="${dtu_sn}" type="hidden">
<input id="size" value="${size}" type="hidden"/>
<h3 style="margin-left: 30px;margin-top: 30px;">传感器节点信息（${dtuInfo.dtu_name}）</h3>
<hr/>
<div style="width: 98%;float: left;margin-left: 20px;margin-right:10px;background-color:  #c2e8ef;">
    <%--<ul class="nav nav-tabs nav-justified">--%>
    <!--导航菜单...-->
    <ul class="nav nav-pills nav-justified">
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=6">数据显示</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=1">DTU信息</a></li>
        <li role="presentation" class="active"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=2">传感器节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=3">控制节点信息</a></li>
        <li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=4">报警信息</a></li>
        <%--<li role="presentation"><a href="${basePath }dtuHome/goDTUPage?nodeId=${dtu_sn}&type=5">分组信息</a></li>--%>

    </ul>
    <!--导航菜单...-->
</div>
<div class="container con_title" style="margin-top: 70px;" >

    <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}">
        <div style="float: right; margin-right: 30px;margin-top: 10px;margin-bottom: 10px; ">
                <%-- --%>
            <button type="button" style="" class="btn btn-info" onclick="syn();" data-toggle="modal" data-target="" ><span class="glyphicon glyphicon-random" aria-hidden="true"></span>&nbsp;一键同步</button>&nbsp;
           <%-- <button type="button" style="" class="btn btn-default" onclick="goTask();" data-toggle="modal" data-target="" ><span class="glyphicon glyphicon-send" aria-hidden="true"></span>&nbsp;任务</button>&nbsp;--%>
            <c:if test="${size < 64}">
                <button type="button" style="" class="btn btn-primary" onclick="add();" data-toggle="modal" data-target="#myModal_add" ><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;新增</button>&nbsp;
            </c:if>
        </div>
    </c:if>

    <table class="table table-striped table-bordered table-hover" style="width: 100%;">
        <thead class="text-center">
            <tr class="" style="background-color: #3278f7;color: white;">
                <td>序号</td>
                <td>传感器名称</td>
                <td>传感器类型码</td>
                <td>传感器地址</td>
                <td>X</td>
                <td>Y</td>
                <td>传感器描述</td>
                <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}"> <td>操作</td></c:if>
            </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach var="sensorNode" items="${sensorNodeInfo.result}" varStatus="status">
            <c:if test="${(status.index+1)%2 == 1}">
                <tr class="info" >
                    <td>${status.index+1}</td>
                    <td>${sensorNode.name}</td>
                    <td>
                        <c:forEach var="type" items="${types.result}" >
                            <c:if test="${type[0] == sensorNode.cfg}">
                                ${type[1]}
                            </c:if>
                        </c:forEach>
                   <%-- ${sensorNode.cfg}--%>
                    </td>
                    <td>${sensorNode.addr}</td>
                    <td>${sensorNode.x}</td>
                    <td>${sensorNode.y}</td>
                    <td>${sensorNode.describ}</td>
                    <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}"> <td>
                        <button type="button" style="" class="btn btn-primary" onclick="upd(${status.index});" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;
                        <button type="button" style="" class="btn btn-danger" onclick="del(${sensorNode.addr});"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;删除</button>&nbsp;
                    </td></c:if>
                </tr>
            </c:if>
            <c:if test="${(status.index+1)%2 == 0}">
                <tr class="active" >
                    <td>${status.index+1}</td>
                    <td>${sensorNode.name}</td>
                    <td>
                        <c:forEach var="type" items="${types.result}" >
                            <c:if test="${type[0] == sensorNode.cfg}">
                                ${type[1]}
                            </c:if>
                        </c:forEach>
                    <%--${sensorNode.cfg}--%>
                    </td>
                    <td>${sensorNode.addr}</td>
                    <td>${sensorNode.x}</td>
                    <td>${sensorNode.y}</td>
                    <td>${sensorNode.describ}</td>
                    <c:if test="${sessionScope.loginInfoSession.result.user_level == '10'|| sessionScope.loginInfoSession.result.user_level == '11'}"> <td>
                        <button type="button" style="" class="btn btn-primary" onclick="upd(${status.index});" data-toggle="modal" data-target="#myModal_upd" ><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;修改</button>&nbsp;
                        <button type="button" style="" class="btn btn-danger" onclick="del(${sensorNode.addr});"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;删除</button>&nbsp;
                    </td></c:if>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>


<!--修改信息 DIV-->
<div class="modal fade" id="myModal_upd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabelupd">修改控制节点信息</h4>
            </div>
            <div class="modal-body" align="center">
                <input type="hidden" value="" id="node_no" />
                <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                    <tr class="info">
                        <td style="width: 35%;">传感器名称：</td>
                        <td style="width: 65%;">
                            <input class="form-control" type="text" value="" id="uname" placeholder="请输入控制器名称" readonly="readonly"  />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>传感器类型：</td>
                        <td>
                            <select class="form-control" id="ucfg">
                                <c:forEach var="type" items="${types.result}" >
                                    <option value="${type[0]}">${type[1]}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>传感器地址：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="uaddr" placeholder="请输入控制器地址" />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>传感器描述：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="udescrib" placeholder="请输入控制器描述" />
                        </td>
                    </tr>
                    <tr class="info">
                        <td>站内坐标X：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="ux"  placeholder="请输入站内坐标X" />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>站内坐标Y：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="uy"  placeholder="请输入站内坐标Y" />
                        </td>
                    </tr>
                </table>
                <span id="upd_msg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updDTUInfo();">保存</button>
            </div>
        </div>
    </div>
</div>
<!--修改信息 DIV-->

<!--新增信息 DIV-->
<div class="modal fade" id="myModal_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabeladd">添加控制节点信息</h4>
            </div>
            <div class="modal-body" align="center">
                <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                    <tr class="active">
                        <td>传感器类型：</td>
                        <td>
                            <select class="form-control" id="acfg">
                                <c:forEach var="type" items="${types.result}" >
                                    <option value="${type[0]}">${type[1]}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="info">
                        <td>传感器地址：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="aaddr" placeholder="请输入传感器地址" />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>传感器描述：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="adescrib" placeholder="请输入传感器描述" />
                        </td>
                    </tr>
                    <tr class="info">
                        <td>站内坐标X：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="ax"  placeholder="请输入站内坐标X" />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>站内坐标Y：</td>
                        <td>
                            <input class="form-control" type="text" value="" id="ay"  placeholder="请输入站内坐标Y" />
                        </td>
                    </tr>
                </table>
                <span id="add_msg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="addInfo();">保存</button>
            </div>
        </div>
    </div>
</div>
<!--新增信息 DIV-->
<%--一键同步弹窗--%>
<div class="modal fade" id="synV">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">一键同步</h4>
            </div>
            <div class="modal-body">
                <span id="pMsg" style="color: red;"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>
