<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>门诊查询</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/ckform.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>

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

<form id="myForm" method="post" class="definewidth m20 form-horizontal">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">病历号：</td>
            <td><input type="text" name="re_id"/></td>

            <td width="10%" class="tableleft">主治医生：</td>
            <td><input type="text" name="d_name"/></td>

            <td width="10%" class="tableleft">科室：</td>
            <td><input type="text" name="d_keshi"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">挂号时间：</td>
            <td colspan="5">
                <input type="date" name="beginTime"/>&nbsp;至&nbsp;<input type="date" name="endTime"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-info" onclick="loadData()">查询</button>
                <button type="reset" class="btn btn-warning">清空</button>
            </td>
        </tr>
    </table>
</form>

<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th><input type="checkbox" id="checkall" onChange="checkAll();"></th>
        <th>门诊编号</th>
        <th>主治医生</th>
        <th>挂号时间</th>
        <th>挂号科室</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="tbody">

    </tbody>
</table>

<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <th colspan="5">
            <div class="inline pull-right page pagination">
                <!--                <span id="firstPage"><a href='#'>首页</a></span> -->
                <!--                <span id="prePage"><a href='#'>上一页</a></span> -->
                <!--                <span id="nextPage"><a href='#'>下一页</a></span> -->
                <!--                <span id="lastPage"><a href='#'>末页</a></span> -->
                <ul class="pagination" style="margin: 0;">
                    <li name="pageLi" id="firstPage"><a href="javascript:void(0)">首页</a></li>
                    <li name="pageLi" id="prePage"><a href="javascript:void(0)">上一页</a></li>
                    <li name="pageLi" id="nextPage"><a href="javascript:void(0)">下一页</a></li>
                    <li name="pageLi" id="lastPage"><a href="javascript:void(0)">末页</a></li>
                </ul>
                &nbsp;第<span class="current" id="currentPage">1</span>页 -
                &nbsp;&nbsp;&nbsp;共<span id="total" class='current'></span>条记录 - <span id="pages"
                                                                                       class='current'></span>页
                <span class="control-label"> &nbsp;每页显示
                    <select name="pageSize" class="" style="width: 40px;height: 25px">
                        <option value="5">5</option>
                        <option value="10">10</option>
                    </select>
                </span>
                <span class="control-label"> &nbsp;- 跳转到 <input name="pageNum" value="1"
                                                                style="height: 16px;width: 40px;border-radius: 10px"/> 页</span>
            </div>
            <div>
                <button type="button" class="btn btn-success" id="newNav">门诊挂号</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">退号</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="getExcel">导出Excel</button>
            </div>
        </th>
    </tr>
</table>
</body>
</html>
<script>
    //页面加载完毕之后发送异步请求
    $(function () {
        loadData();
        $("ul[class='pagination']>li").click(function () {
            if (($(this).attr("class")) == 'disabled')
                return;
            var num = $(this).attr("name");
            $("input[name='pageNum']").val(num);
            loadData();
        });
    });

    // 填充分页信息
    function fillPageData(pageInfo) {
        // 填充信息
        $("#total").html(pageInfo.total);
        $("#pages").html(pageInfo.pages);
        $("input[name='pageNum']").val(pageInfo.pageNum);
        $("select[name='pageSize']").val(pageInfo.pageSize);
        // 设置按钮的属性值和样式
        $("#firstPage").attr("name", 1);
        $("#prePage").attr("name", pageInfo.prePage);
        $("#currentPage").attr("name", pageInfo.pageNum);
        $("#nextPage").attr("name", pageInfo.nextPage);
        $("#lastPage").attr("name", pageInfo.pages);

        $("#firstPage").removeClass("disabled");
        $("#prePage").removeClass("disabled");
        $("#nextPage").removeClass("disabled");
        $("#lastPage").removeClass("disabled");

        if (pageInfo.isFirstPage) {
            // 如果是第一页：上一页和首页禁用
            $("#firstPage").addClass("disabled");
            $("#prePage").addClass("disabled");
        }
        if (pageInfo.isLastPage) {
            // 如果是最后一页：下一页和末页禁用
            $("#nextPage").addClass("disabled");
            $("#lastPage").addClass("disabled");
        }
    }

    // 更改选项
    function updateReg(id) {
        var pageNum = $("input[name='pageNum']").val();
        var pageSize = $("select[name='pageSize']").val();
        window.location.href = "/pages/registration/edit.jsp?re_id=" + id + "&pageNum=" + pageNum + "&pageSize=" + pageSize;
    }

    // 退号
    function delReg(id) {
        if (confirm("确定要删除吗？")) {
            // 发起异步请求
            $.ajax({
                type: "POST",
                url: "/register/" + id,
                data: "_method=DELETE",
                success: function (vo) {
                    if (vo.code == 200) {
                        loadData();
                    } else {
                        alert("删除失败！" + vo.msg);
                    }
                }
            })
        }
    }

    // 挂号新增
    $(function () {
        $('#newNav').click(function () {
            window.location.href = "add.jsp";
        });
    });

    // 全选
    function checkAll() {
        var alls = document.getElementsByName("check");
        var ch = document.getElementById("checkall");
        if (ch.checked) {
            for (var i = 0; i < alls.length; i++) {
                alls[i].checked = true;
            }
        } else {
            for (var i = 0; i < alls.length; i++) {
                alls[i].checked = false;
            }
        }
    }

    // 删除全部
    function delAll() {
        var alls = document.getElementsByName("check");
        var ids = new Array();
        for (var i = 0; i < alls.length; i++) {
            if (alls[i].checked) {
                ids.push(alls[i].value);
            }
        }
        if (ids.length > 0) {
            if (confirm("确认操作?")) {
                alert("成功!");
            }
        } else {
            alert("请选中要操作的项");
        }
    }

    String.prototype.GetValue = function (para) {
        var reg = new RegExp("(^|&)" + para + "=([^&]*)(&|$)");
        var r = this.substr(this.indexOf("\?") + 1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }

    // 加载数据
    function loadData() {
        var url = document.location.toString();
        var pageNum = url.GetValue("pageNum");
        var pageSize = url.GetValue("pageSize");
        if (pageNum != null && $("input[name='pageNum']").val() != null) {
            $("select[name='pageNum']").val(pageNum);
        }
        if (pageSize != null && $("select[name='pageSize']").val() != null) {
            $("select[name='pageSize']").val(pageSize);
        }
        $.ajax({
            type: "GET",
            url: "/register/list",
            data: $("#myForm").serialize(),
            dataType: "json",
            success: function (vo) {
                var list = vo.pageInfo.list;
                var str = "";
                for (var i = 0; i < list.length; i++) {
                    var obj = list[i];
                    var re_id = obj.re_id;
                    var d_name = obj.doctor.d_name;
                    var re_createTime = obj.re_createTime;
                    var d_keshi = obj.doctor.d_keshi;
                    var re_state = "";
                    if (obj.re_state == 0) {
                        re_state = "已挂号";
                    } else if (obj.re_state == 1) {
                        re_state = "已住院";
                    } else if (obj.re_state == 2) {
                        re_state = "已出院";
                    } else if (obj.re_state == 3) {
                        re_state = "已退号";
                    }
                    var btnStr = "";
                    if (obj.re_state == 0) {
                        btnStr = '<a href="look.jsp">详情>>></a>&nbsp;&nbsp;&nbsp;' +
                            '<a href="#" onclick="updateReg(' + re_id + ')">更改</a>&nbsp;&nbsp;&nbsp;' +
                            '<a href="#" onclick="delReg(' + re_id + ')">退号</a>';
                    } else if (obj.re_state == 1) {
                        btnStr = '<a href="look.jsp">详情>>></a>&nbsp;&nbsp;&nbsp;' +
                            '<a href="#" onclick="updateReg(' + re_id + ')">更改</a>&nbsp;&nbsp;&nbsp;';
                    } else {
                        btnStr = '<a href="look.jsp">详情>>></a>&nbsp;&nbsp;&nbsp;';
                    }
                    str += '<tr>' +
                        '<td><input type="checkbox" name="check" value="1"/></td>' +
                        '<td>' + re_id + '</td>' +
                        '<td>' + d_name + '</td>' +
                        '<td>' + re_createTime + '</td>' +
                        '<td>' + d_keshi + '</td>' +
                        '<td>' + re_state + '</td>' +
                        '<td>' + btnStr + '</td>' +
                        '</tr>';
                }
                $("#tbody").html(str);
                // 填充分页数据
                fillPageData(vo.pageInfo);
            }
        });
    }
</script>
