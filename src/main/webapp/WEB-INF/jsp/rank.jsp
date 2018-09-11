<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>热搜排行榜</title>
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
            <h3 class="text-center">热搜排行榜</h3>
            <p class="text-center">书中自有颜如玉</p>
        </div>
    </div>
    <div class="container">
        <table class="table">
            <tr>
                <th>排名</th>
                <th>关键字</th>
                <th>搜索次数</th>
            </tr>
            <c:forEach items="${requestScope.rankList }" var="item" varStatus="status">
	            <tr>
	                <td>${status.index + 1 }</td>
	                <td>${item.keyWord }</td>
	                <td>${item.times }</td>
	            </tr>
            </c:forEach>
            
        </table>
        <a href="index.html" class="btn btn-block btn-default">返回首页</a>
    </div>
    <p class="footer">All rights reserve &copy; 2013-2017 天高科技工作室</p>
</body>
</html>