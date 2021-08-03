<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>门诊挂号</title>
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
    <script type="text/javascript">
        $(function () {
            $('#backId').click(function () {
                window.location.href = "list.jsp";
            });
        });
    </script>
</head>
<body>
<form id="myForm" method="post" class="definewidth m20" action="/register">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <td><input type="text" name="re_name"/></td>
        </tr>

        <tr>
            <td width="10%" class="tableleft">身份证号</td>
            <td><input type="text" name="re_idCard"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">社保号</td>
            <td><input type="text" name="re_medical"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">挂号费</td>
            <td><input type="text" name="re_price" value=""/>元</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">联系电话</td>
            <td><input type="text" name="re_phone" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">是否自费</td>
            <td>
                <input type="radio" name="re_selfPrice" value="0" checked/>是&nbsp;&nbsp;&nbsp;
                <input type="radio" name="re_selfPrice" value="1"/>否
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>
                <input type="radio" name="re_sex" value="0" checked/>女&nbsp;&nbsp;&nbsp;
                <input type="radio" name="re_sex" value="1"/>男
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td><input type="text" name="re_age"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">职业</td>
            <td><input type="text" name="re_job"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">初复诊</td>
            <td><input type="radio" name="re_lookDoc" value="0" checked/>初诊&nbsp;&nbsp;&nbsp;
                <input type="radio" name="re_lookDoc" value="1"/>复诊
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所挂科室</td>
            <td>
                <select id="d_keshi" name="d_keshi" onchange="getDoc()">
                    <option value="-1">请选择</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">指定医生</td>
            <td>
                <select id="d_name" name="d_name">
                    <option value="-1">请选择</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><textarea name="re_remark"></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <center>
                    <button id="btnAdd" type="button" class="btn btn-primary" type="button">新增</button> &nbsp;&nbsp;
                    <button type="button" class="btn btn-success" name="backId" id="backId">返回列表</button>
                </center>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script>
    // 动态获取科室信息
    $.ajax({
        type: "GET",
        url: "/keshi/list",
        dataType: "json",
        success: function (vo){
            for (let i in vo){
                $("#d_keshi").append("<option value='" + i + "'>" + vo[i].d_keshi + "</option>");
            }
        }
    });

    // 级联获取医生信息
    function getDoc(){
        $("#d_name").empty();
        let val = $("#d_keshi").find("option:selected").attr("value");
        if (val >= 0) {
            $.ajax({
                type: "GET",
                url: "/keshi/" + val,
                dataType: "json",
                success: function (vo) {
                    for (let i in vo) {
                        $("#d_name").append("<option value='" + vo[i].d_name +  "'>" + vo[i].d_name + "</option>");
                    }
                }
            });
        }
    }

    // 新增挂号信息
    $(function (){
       $("#btnAdd").click(function (){
           $.ajax({
               type: "POST",
               url: "/register/",
               data: $("#myForm").serialize(),
               dataType: "json",
               success: function (vo){
                   if (vo.code == 200) {
                       alert("添加成功！");
                       window.location.href = "list.jsp";
                   } else {
                       alert("添加失败！" + vo.msg);
                   }
               }
           })
       })
    });
</script>