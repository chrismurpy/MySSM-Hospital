<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>挂号更改</title>
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
<form id="myForm" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <td>
                <input type="text" name="re_name"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">身份证号</td>
            <td>
                <input type="text" name="re_idCard"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">挂号费</td>
            <td>
                <input type="text" name="re_price"/>元
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">社保号</td>
            <td>
                <input type="text" name="re_medical"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">联系电话</td>
            <td>
                <input type="text" name="re_phone"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">是否自费</td>
            <td>
                <input type="radio" id="re_self1" name="re_selfPrice" value="1" checked/>否&nbsp;&nbsp;&nbsp;
                <input type="radio" id="re_self0" name="re_selfPrice" value="0"/>是
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>
                <input type="radio" id="re_sex1" name="re_sex" value="1" checked/>男&nbsp;&nbsp;&nbsp;
                <input type="radio" id="re_sex0" name="re_sex" value="0"/>女
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td>
                <input type="text" name="re_age"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">职业</td>
            <td>
                <input type="text" name="re_job"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">初复诊</td>
            <td>
                <input type="radio" id="re_lookDoc0" name="re_lookDoc" value="0" checked/>初诊&nbsp;&nbsp;&nbsp;
                <input type="radio" id="re_lookDoc1" name="re_lookDoc" value="1"/>复诊
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
            <td>
                <textarea name="re_remark"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <center>
                    <button type="button" class="btn btn-primary" id="saveBtn">保存</button> &nbsp;&nbsp;
                    <button type="button" class="btn btn-success" name="backId" id="backId">返回列表
                    </button>
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
        success: function (vo) {
            for (let i in vo) {
                $("#d_keshi").append("<option value='" + i + "' name='" + vo[i].d_keshi + "'>" + vo[i].d_keshi + "</option>");
            }
        }
    });

    // 级联获取医生信息
    function getDoc() {
        $("#d_name").empty();
        let val = $("#d_keshi").find("option:selected").attr("value");
        if (val >= 0) {
            $.ajax({
                type: "GET",
                url: "/keshi/" + val,
                dataType: "json",
                success: function (vo) {
                    for (let i in vo) {
                        $("#d_name").append("<option value='" + vo[i].d_name + "' name='" + vo[i].d_name + "'>" + vo[i].d_name + "</option>");
                    }
                }
            });
        }
    }

    String.prototype.GetValue= function(para) {
        let reg = new RegExp("(^|&)"+ para +"=([^&]*)(&|$)");
        let r = this.substr(this.indexOf("\?")+1).match(reg);
        if (r!=null) return unescape(r[2]); return null;
    }

    $(function () {
        // 获取URL
        let url = document.location.toString();
        let re_id = url.GetValue("re_id");
        queryById(re_id);

        $("#saveBtn").click(function () {
            $.ajax({
                type: "POST",//这里必须写POST
                url: "/register/" + re_id, //RESTful风格的API定义
                data: $("#myForm").serialize() + "&_method=PUT",
                dataType: "json",
                success: function (vo) {
                    if (vo.code == 200) {
                        alert("保存成功！");
                        window.location.href = "/pages/registration/list.jsp";
                    } else {
                        alert("保存失败！" + vo.msg);
                    }
                }
            });
        });
    });

    function queryById(re_id) {
        $.ajax({
            type: "GET",
            url: "/register/" + re_id,
            data: "",
            success: function (vo) {
                let obj = vo.obj;
                let re_name = obj.re_name;
                let re_idCard = obj.re_idCard;
                let re_price = obj.re_price;
                let re_medical = obj.re_medical;
                let re_phone = obj.re_phone;
                let re_selfPrice = obj.re_selfPrice;
                let re_sex = obj.re_sex;
                let re_age = obj.re_age;
                let re_job = obj.re_job;
                let re_lookDoc = obj.re_lookDoc;
                let d_keshi = obj.doctor.d_keshi;
                let d_name = obj.doctor.d_name;
                let re_remark = obj.re_remark;

                $("input[name='re_name']").val(re_name);
                $("input[name='re_idCard']").val(re_idCard);
                $("input[name='re_price']").val(re_price);
                $("input[name='re_medical']").val(re_medical);
                $("input[name='re_phone']").val(re_phone);
                if (re_selfPrice == 0) {
                    $("#re_self0").attr("checked", "checked");
                } else {
                    $("#re_self1").attr("checked", "checked");
                }
                if (re_sex == 0) {
                    $("#re_sex0").attr("checked", "checked");
                } else {
                    $("#re_sex1").attr("checked", "checked");
                }
                if (re_lookDoc == 0) {
                    $("#re_lookDoc0").attr("checked", "checked");
                } else {
                    $("#re_lookDoc1").attr("checked", "checked");
                }
                $("input[name='re_age']").val(re_age);
                $("input[name='re_job']").val(re_job);
                $("textarea[name='re_remark']").val(re_remark);

                addDoc(d_name, d_keshi);
            }
        });
    }

    function addDoc(d_name, d_keshi) {
        $("#d_keshi").find("option[name=" + d_keshi + "]").prop("selected", true);
        getDoc();
    }
</script>