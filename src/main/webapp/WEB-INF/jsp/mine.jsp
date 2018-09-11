<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>我的书单</title>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="apple-mobile-web-app-capable" content="no" />
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-base.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-mine.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <h3 class="text-center">我的书单</h3>
            <p class="text-center">让阅读成为一种习惯</p>
        </div>
    </div>
    <div class="container">
        <table class="table">
            <tr><th  class="bookname">书名</th><th class="number">图书编号</th><th class="remove">操作</th></tr>
            <c:forEach items="${requestScope.myBookList }" var="item">
            		<tr data-id="${item.id }"><td class="bookname">${item.bookName }</td><td class="number">${item.bookNumber }</td><td class="remove"><button type="button" class="btn btn-xs btn-warning remove-btn" id="s1">移除</button></td></tr>
            </c:forEach>
        </table>
         <a href="index.html" class="btn btn-block btn-default">返回首页</a>
    </div>
    <p class="footer">All rights reserve &copy; 2013-2017 天高科技工作室</p>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/booklist.js"></script>
</body>
</html>