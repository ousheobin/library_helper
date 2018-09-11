<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>图书小助手</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/res/front/css/style-weui.css">
    <style>
      .hints{
        margin: 10px 15px;
        text-align: center;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="container">
      <p style="margin: 100px auto;text-align: center;">
        <i class="weui-icon-warn weui-icon_msg"></i>
      </p>
     <p class="hints" style="font-size:20px;">
        无法处理请求
      </p>
      <p class="hints">
        发生错误了，非常抱歉
      </p>
      <p class="hints" style="font-size:12px;">
        We feel sorry about this. <br> Please try again later or contact us.
      </p>
    </div>
    </div>
  </body>
</html>
