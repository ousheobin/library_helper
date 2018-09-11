<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>${requestScope.book.title }-查询结果</title>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="apple-mobile-web-app-capable" content="no" />
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-base.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-result.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
    <script type="text/javascript">
    		var spmSource = "${requestScope.spm}";
    		var isBack = "${requestScope.isBack}";
    </script>
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <h3 class="text-center">查询结果</h3>
            <p class="text-center go-back"><a href="javascript:history.go(-1)">返回查询页</a></p>
        </div>
    </div>
    <div class="container">
        <div>
            <p class="title">图书信息</p>
            <table class="table">
                <tr>
                    <td class="item-title">书籍名称</td>
                    <td id="bookName">${requestScope.book.title }</td>
                </tr>
                <tr>
                    <td class="item-title">作者</td>
                    <td>${requestScope.book.author }</td>
                </tr>
                <tr>
                    <td class="item-title">出版社</td>
                    <td>${requestScope.book.publisher }</td>
                </tr>
                <tr>
                    <td class="item-title">ISBN</td>
                    <td>${requestScope.book.isbn }</td>
                </tr>
                <tr>
                    <td class="item-title">图书馆索书号</td>
                    <td id="code">${requestScope.book.libNumber }</td>
                </tr>
            </table>
            <c:if test="${requestScope.showAddBtn }">
            		<button type="button"class="btn btn-success btn-block" id="addToBookList">添加到我的书单</button>
            </c:if>
             <c:if test="${!requestScope.showAddBtn }">
            		<button type="button"class="btn btn-success btn-block disabled">已经到我的书单</button>
            </c:if>
            <hr>
            <p class="title">馆藏信息</p>
            <table class="table borrows">
                <tr>
                    <th class="col-md-3 col-sm-3 col-xs-4">图书条码</th>
                    <th class="col-md-3 col-sm-3 col-xs-4">馆藏位置</th>
                    <th class="col-md-3 col-sm-3 col-xs-4 hidden-xs">应还日期</th>
                    <th class="col-md-3 col-sm-3 col-xs-4">状态</th>
                </tr>
                <c:forEach items="${requestScope.book.borrows }" var="item">
                	<tr>
                    <td>${item.code }</td>
                    <td>${item.place }</td>
                    <td class="hidden-xs">${item.returnTime }</td>
                    <td>${item.status }</td>
                </tr>
                </c:forEach>
            </table>
            <a href="index.html" class="btn btn-block btn-default">返回首页</a>
        </div>
    </div>
    <p class="footer">All rights reserve &copy; 2013-2017 天高科技工作室</p>
     <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/detail.js"></script>
</body>
</html>