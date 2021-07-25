<%--
  Created by IntelliJ IDEA.
  User: murphy
  Date: 2021/7/25
  Time: 6:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医院管理系统</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.sorted.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/ckform.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <style type="text/css">
        body {
            background-color: #0093E9;
            background-image: linear-gradient(160deg, #0093E9 0%, #80D0C7 100%);
        }
        div {
            padding-top: 160px;
            padding-bottom: 25%;
            /*background-color: #f5f5f5;*/
        }

        .form-signin {
            max-width: 300px;
            padding: 100px 70px 50px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 30px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 15px;
            height: auto;
            margin-bottom: 25px;
            padding: 10px 10px;
        }

    </style>
</head>
<body>
<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <h2 class="form-signin-heading" style="text-align: center">&nbsp;&nbsp;&nbsp;登录系统<small> <em>Welcome</em> </small></h2>
        <input type="text" id="username" name="u_LoginName" class="input-block-level" placeholder="账号" required>
        <input type="password" id="password" name="u_password" class="input-block-level" placeholder="密码">
        <input type="text" name="verify" class="input-medium" placeholder="验证码">
        <img src="/checkCode" id="checkCode" title="看不清，点击换一张" alt="" width="100" height="32" class="center-block" style="height:43px;cursor:pointer;" onclick="getPic()"/>
        <script type="text/javascript">
            function getPic(){
                $("#checkCode").attr("src","/checkCode?flag="+Math.random());
            };
        </script>


        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="btn btn-large btn-info" type="submit">登录</button>
            <span style="color: red;height: 50px;line-height: 50px">${msg}</span>
        </p>
    </form>
</div>
</body>
</html>
