<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>请选择具体的书籍</title>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="apple-mobile-web-app-capable" content="no" />
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-base.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-res.css" />
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <p class="text-center">查询到这个系列有多个版本<br>请选择具体书籍</p>
            <p class="text-center go-back"><a href="javascript:history.go(-1);">返回</a></p>
        </div>
    </div>
        <div class="container">
        <c:forEach items="${requestScope.category.data }" var="item">
        		<div class="col-md-12 detail">
                <a href="${item.url }" class="title"><p>${item.bookName }</p>
                    <span class="enter">&gt;</span>
                </a>
            </div>
        </c:forEach>
        </div>
        <p class="footer">All rights reserve &copy; 2013-2017 天高科技工作室</p>
</body>
</html>