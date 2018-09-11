<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>查书小助手</title>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="apple-mobile-web-app-capable" content="no" />
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/res/css/style-base.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/res/css/style-index.css" />
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <h3 class="text-center">查书小助手</h3>
            <p class="text-center">欲遂平生志，勤向窗前读</p>
        </div>
    </div>
    <div class="container">
        <div class="col-md-4 col-xs-12 col-sm-12 index-button">
            <a class="query-btn" href="./search.html">书籍查询</a>
        </div>
        <div class="col-md-4 col-xs-12 col-sm-12 index-button">
            <a class="mine-btn" href="./mine.html" >我的书单</a>
        </div>
        <div class="col-md-4 col-xs-12 col-sm-12 index-button">
            <a class="rank-btn" href="./rank.html">查询排行榜</a>
        </div>
    </div>
    <p class="footer">All rights reserve &copy; 2013-2017 天高科技工作室</p>
</body>
</html>