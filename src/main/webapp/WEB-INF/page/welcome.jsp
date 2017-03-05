<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/25
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DTU</title>
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
</head>
<body>
<%--<h3>欢迎进入DTU管理系统</h3>--%>
<div id="allmap"></div>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PADGTF9CvlqcLGcDo7nKjeUGAkauOGVv"></script>
<script type="text/javascript">
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(116.404, 39.915);
    map.centerAndZoom(point, 15);
    map.enableScrollWheelZoom(true);
    // 编写自定义函数,创建标注
    function addMarker(point){
        var marker = new BMap.Marker(point);
        marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
        map.addOverlay(marker);
    }
    // 随机向地图添加25个标注
    var bounds = map.getBounds();
    var sw = bounds.getSouthWest();
    var ne = bounds.getNorthEast();
    var lngSpan = Math.abs(sw.lng - ne.lng);
    var latSpan = Math.abs(ne.lat - sw.lat);
    for (var i = 0; i < 25; i ++) {
        var point = new BMap.Point(sw.lng + lngSpan * (Math.random() * 0.7), ne.lat - latSpan * (Math.random() * 0.7));
        addMarker(point);
    }
</script>
</body>
</html>
