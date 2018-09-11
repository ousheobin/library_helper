<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>${requestScope.word }-图书馆小助手</title>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="apple-mobile-web-app-capable" content="no" />
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-base.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-res.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/res/css/style-weui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
    <script type="text/javascript">
    		var word = "${requestScope.word }";
    	</script>
</head>
<body>
    <div class="container search-form">
        <form action="result.html" method="post">
            <div class="col-md-10 col-xs-8 col-xs-8">
                <input class="form-control col-md-8 col-xs-8 col-xs-8" placeholder="请输入您需要查询的书籍" value="${requestScope.word }" name="word">
            </div>
            <div class="col-md-2 col-xs-4 col-xs-4">
                <button class="btn btn-success btn-block">查询</button>
            </div>
        </form>
    </div>
    <div class="container">
        <div id="result"></div>
        <button class="btn btn-info btn-block more" id="more" style="display:none;">加载更多</button>
        <a href="index.html" class="btn btn-block btn-default">返回首页</a>
    </div>
    <div id="loading">
        <div class="weui-mask_transparent"></div>
        <div class="weui-toast">
            <i class="weui-loading weui-icon_toast"></i>
            <p class="weui-toast__content">数据加载中</p>
        </div>
    </div>
    <p class="footer">All rights reserve &copy; 2013-2017 天高科技工作室</p>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/result.js"></script>
</body>
</html>