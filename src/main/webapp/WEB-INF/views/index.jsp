<%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2020/6/3
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <link rel="stylesheet" href="${ initParam.webUrl }/static/css/index.css">
    <script src="${ initParam.webUrl }/static/js/jquery-3.4.1.js"></script>
    <script src="${ initParam.webUrl }/static/js/multiFile_uploading.js"></script>
</head>
<body>
    <div id="main">
        <div class="select">
            <button type="button" class="index_btn mfu_1">多文件上传【无限制】</button>
            <button type="button" class="index_btn mfu">单文件上传【无限制】</button>
        </div>
        <div class="fill_area"></div>
    </div>
</body>
</html>
