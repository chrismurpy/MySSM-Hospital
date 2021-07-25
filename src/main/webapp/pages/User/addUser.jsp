<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/style.css"/>
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>


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
    <script>
        $(function () {
            $('#backid').click(function () {
                window.location.href = "index.jsp";
            });
        });
    </script>
</head>
<body>
<form action="index.jsp" method="post" class="definewidth m20">
    <input type="hidden" name="id" value="{$user.id}"/>
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">登录名</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="realname"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
                <input type="radio" name="status" value="0" checked/> 启用
                <input type="radio" name="status" value="1"/> 禁用
            </td>
        </tr>
        <tr>
            <td class="tableleft">角色</td>
            <td>
                <select name="role">
                    <option value="">--请选择--
                    <option value="1">管理员
                    <option value="2">院长
                    <option value="3">医生护士
                </select>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">更新</button>&nbsp;&nbsp;<button type="button"
                                                                                                           class="btn btn-success"
                                                                                                           name="backid"
                                                                                                           id="backid">
                返回列表
            </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>