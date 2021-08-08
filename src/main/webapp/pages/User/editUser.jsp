<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户更改</title>
<%--    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>--%>
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

    <script>
        $(function () {
            $('#backid').click(function(){
                window.location.href="index.jsp";
            });
        });
    </script>
</head>
<body>

<form  id="userForm" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">登录名</td>
            <td><input type="text" name="u_LoginName"></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="text" name="u_password"/></td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="u_trueName" /></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="u_email" /></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
                <input type="radio" id="u_state0" name="u_state" value="0" checked/> 启用
              <input type="radio" id="u_state1" name="u_state" value="1" /> 禁用
            </td>
        </tr>
        <tr>
            <td class="tableleft">角色</td>
            <td>
            	<select name="r_name" id="r_name" onchange="getDoc()">
        			<option value="-1">--请选择--
  <%--      			<option value="1" selected>管理员
        			<option value="2">院长
            		<option value="3">医生护士--%>
       			 </select>
        	</td>
        </tr>
        <tr>
            <td colspan="2">
                <center>
                <button type="submit" class="btn btn-primary" type="button" id="saveBtn">更新</button>&nbsp;&nbsp;
                <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
                </center>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<script>
    // 动态获取角色信息
    $.ajax({
        type: "GET",
        url: "/role/index",
        dataType: "json",
        success: function (vo) {
            for (let i in vo) {
                $("#r_name").append("<option value='" + i + "' name='" + vo[i].r_name + "'>" + vo[i].r_name + "</option>");
            }
        }
    });

    String.prototype.GetValue= function(para) {
        let reg = new RegExp("(^|&)"+ para +"=([^&]*)(&|$)");
        let r = this.substr(this.indexOf("\?")+1).match(reg);
        if (r!=null) return unescape(r[2]); return null;
    }

    $(function () {
        // 获取URL
        let url = document.location.toString();
        let u_LoginName = url.GetValue("u_LoginName");
        queryById(u_LoginName);

        $("#saveBtn").click(function () {
            $.ajax({
                type: "POST",//这里必须写POST
                url: "/User/" + u_LoginName, //RESTful风格的API定义
                data: $("#userForm").serialize() + "&_method=PUT",
                dataType: "json",
                success: function (vo) {
                    if (vo.code == 200) {
                        alert("保存成功！");
                        window.location.href = "/pages/User/index.jsp";
                    } else {
                        alert("保存失败！" + vo.msg);
                    }
                }
            });
        });
    });


    function queryById(u_LoginName) {
        $.ajax({
            type: "GET",
            url: "/User/" + u_LoginName,
            data: "",
            success: function (vo) {
                let obj = vo.obj;
                let u_password = obj.u_password;
                let u_trueName = obj.u_trueName;
                let u_email = obj.u_email;
                let u_state = obj.u_state;
                let r_name = obj.role.r_name;

                $("input[name='u_LoginName']").val(u_LoginName);
                $("input[name='u_password']").val(u_password);
                $("input[name='u_trueName']").val(u_trueName);
                $("input[name='u_email']").val(u_email);

                if (u_state == 0) {
                    $("#u_state0").attr("checked", "checked");
                } else {
                    $("#u_state1").attr("checked", "checked");
                }

                addDoc(r_name);
            }
        });
    }

    function addDoc(r_name) {
        $("#r_name").find("option[name=" + r_name + "]").prop("selected", true);
        //getDoc();
    }



</script>

