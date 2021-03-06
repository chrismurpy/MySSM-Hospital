<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看</title>
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
                window.location.href = "/pages/registration/list.jsp";
            });
        });
    </script>
</head>
<body>
<form id="myForm" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <td>
                <span id="re_name" name="re_name"></span>
            </td>
        </tr>

        <tr>
            <td width="10%" class="tableleft">身份证号</td>
            <td>
                <span id="re_idCard" name="re_idCard"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">挂号费</td>
            <td>
                <span id="re_price" name="re_price"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">社保号</td>
            <td>
                <span id="re_medical" name="re_medical"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">联系电话</td>
            <td>
                <span id="re_phone" name="re_phone"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">是否自费</td>
            <td>
                <span id="re_selfPrice" name="re_selfPrice"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>
                <span id="re_sex" name="re_sex"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td>
                <span id="re_age" name="re_age"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">职业</td>
            <td>
                <span id="re_job" name="re_job"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">初复诊</td>
            <td>
                <span id="re_lookDoc" name="re_lookDoc"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所挂科室</td>
            <td>
                <span id="d_keshi"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">指定医生</td>
            <td>
                <span id="d_name"></span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td>
                <span id="re_remark"></span>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <center>
                    <button type="button" class="btn btn-success" name="backId" id="backId">返回列表</button>
                </center>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<script>
    String.prototype.GetValue= function(para) {
        let reg = new RegExp("(^|&)"+ para +"=([^&]*)(&|$)");
        let r = this.substr(this.indexOf("\?")+1).match(reg);
        if (r!=null) return unescape(r[2]); return null;
    }

    $(function (){
        // 获取URL
        let url = document.location.toString();
        // console.log(url + " - url")
        let re_id = url.GetValue("re_id");
        // console.log(re_id + " - re_id");
        queryById(re_id);
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

                $("#re_name").html(re_name).addClass("disabled");
                $("#re_idCard").html(re_idCard).addClass("disabled");
                $("#re_price").html(re_price).addClass("disabled");
                $("#re_medical").html(re_medical).addClass("disabled");
                $("#re_phone").html(re_phone).addClass("disabled");
                if (re_selfPrice == 0) {
                    $("#re_selfPrice").html("自费").addClass("disabled");
                } else {
                    $("#re_selfPrice").html("免费").addClass("disabled");
                }
                if (re_sex == 0) {
                    $("#re_sex").html("女").addClass("disabled");
                } else {
                    $("#re_sex").html("男").addClass("disabled");
                }
                $("#re_age").html(re_age).addClass("disabled");
                $("#re_job").html(re_job).addClass("disabled");
                if (re_lookDoc == 0) {
                    $("#re_lookDoc").html("初诊").addClass("disabled");
                } else {
                    $("#re_lookDoc").html("复诊").addClass("disabled");
                }
                $("#d_keshi").html(d_keshi).addClass("disabled");
                $("#d_name").html(d_name).addClass("disabled");
                $("#re_remark").html(re_remark).addClass("disabled");
            }
        });
    }
</script>