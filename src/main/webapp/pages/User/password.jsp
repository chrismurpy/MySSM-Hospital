<%--
  Created by IntelliJ IDEA.
  User: Ann
  Date: 2021/8/10
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/ckform.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/ckeditor/ckeditor.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }

        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }

    </style>

</head>
<body>
<form id="myForm" class="form-horizontal" method="get">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">请输入原密码:</td>
            <td width="80%"><input type="text" id="oldPassword" name="oldPassword" value="" /></td>
        </tr>
        <tr>
            <td class="tableleft">请输入新密码:</td>
            <td><input type="password" id="newPassword" name="newPassword" value=""/></td>
        </tr>
        <tr>
            <td class="tableleft">请确认新密码:</td>
            <td><input type="password" id="confirmPassword" name="confirmPassword" value="" /></td>
        </tr>
        <tr>
            <td colspan="5">
                <button class="btn btn-primary" type="button" id="saveBtn">更新</button>&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<script>

    let loginPassword = "${loginPassword}";

    $(function () {

        $("#oldPassword").blur(function(){
            checkOldPassword();
        });

/*        $("#newPassword").blur(function(){
            checkNewPassword();
        });*/

        $("#confirmPassword").blur(function(){
            checkConfirmPassword();
        });

        $("#saveBtn").click(function () {
            $.ajax({
                type: "POST",//这里必须写POST
                url: "/User/password" , //RESTful风格的API定义
                data: $("#myForm").serialize() + "&_method=PUT",
                dataType: "json",
                success: function (vo) {
                    if (vo.code == 200) {
                        alert("密码修改成功！");
                        window.location.href = "/pages/login.jsp";
                    } else {
                        alert("密码修改失败！" + vo.msg);
                    }
                }
            });
        });



    })

    //验证原密码输入是否正确
    function checkOldPassword() {
        if ($("#oldPassword").val()==""){
            alert("请输入正确的原密码！");
        }else if ($("#oldPassword").val()!=loginPassword){
            alert("您输入的原密码不正确，请重新输入！");
        }
    }

    //验证新密码输入是否正确
    function checkNewPassword() {
        if ($("#newPassword").val()==""){
            alert("新密码不能为空！");
        }else if ($("#newPassword").val().length<8){
            alert("密码长度至少为8位！");
        }else {
            alert("您输入的新密码正确，请再次输入！");
        }
    }

    //验证两次输入输入是否正确
    function checkConfirmPassword() {
        if ($("#confirmPassword").val()==""){
            alert("新密码不能为空");
        }else if ($("#confirmPassword").val()!=$("#newPassword").val()){
            alert("两次输入不一致，请重新输入！");
        }
    }




</script>
