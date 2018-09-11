<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-base.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-search.css" />
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <h3 class="text-center">查书小助手</h3>
            <p class="text-center">让查书更简单</p>
        </div>
    </div>
    <div class="container">
        <form action="result.html" method="post">
            <input class="form-control" placeholder="请输入您需要查询的书籍" name="word">
            <button class="btn btn-success btn-block">查询</button>
            <a href="index.html" class="btn btn-block btn-default">返回首页</a>
        </form>
    </div>
    <p class="footer">All rights reserve &copy; 2013-2017 天高科技工作室</p>
</body>
</html>