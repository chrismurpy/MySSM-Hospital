<%--
  Created by IntelliJ IDEA.
  User: murphy
  Date: 2021/8/2
  Time: 2:28 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form id="myForm" class="form-horizontal" method="post">

    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">病历号：</td>
            <td><input type="text" name="re_id" value=""/></td>

            <td width="10%" class="tableleft">主治医生：</td>
            <td><input type="text" name="d_name" value=""/></td>

            <td width="10%" class="tableleft">科室：</td>
            <td><input type="text" name="d_keshi" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">挂号时间：</td>
            <td colspan="5">
                <input type="date" name="beginTime"/>&nbsp;至&nbsp;<input type="date" name="endTime"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" onclick="loadData()" class="btn btn-info">查询</button>
                <button type="reset" class="btn btn-warning">清空</button>
            </td>
        </tr>
    </table>

    <table class="table table-bordered table-hover definewidth m10">
        <thead>
        <tr>
            <th><input type="checkbox" id="checkall" onclick="checkAll2()"></th>
            <th>病历号</th>
            <th>主治医生</th>
            <th>挂号时间</th>
            <th>挂号科室</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody id="tboby">
        <tr>
            <td><input type="checkbox" name="one"/></td>
            <td>1001</td>
            <td>张三</td>
            <td>2021</td>
            <td>皮肤科</td>
            <td>已挂号</td>
            <td style="vertical-align:middle;"><a href="look.html">详情>>></a>&nbsp;&nbsp;&nbsp;<a href="edit.html">更改</a>&nbsp;&nbsp;&nbsp;
                <a href="javascript:alert('退号成功！');">退号</a>
            </td>
        </tr>
        </tbody>
    </table>

    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <th>
                <div>
                    <center>
                        共 <span id="total" class="current"></span> 条数据，共 <span id="pages" class="current"></span> 页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        每页显示
                        <select class="form-control" name="pageSize" style="width: 55px;height: 25px">
                            <option value="5">5</option>
                            <option value="10">10</option>
                            <option value="15">15</option>
                        </select>
                        条数据&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        跳转到第
                        <input class="form-control" name="pageNum" value="1"
                               style="height: 20px;width: 40px;border-radius: 8px;text-align: center"/>
                        页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-default" id="firstPage" name="pageLi">首页</a>&nbsp;
                        <a class="btn btn-default" id="prePage" name="pageLi">上一页</a>&nbsp;
                        <a class="btn btn-default" id="nextPage" name="pageLi">下一页</a>&nbsp;
                        <a class="btn btn-default" id="lastPage" name="pageLi">末页</a>&nbsp;
                    </center>
                </div>
            </th>
        </tr>
    </table>

    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <th colspan="5">
                <div>
                    <button type="button" class="btn btn-success" id="newNav">门诊挂号</button>&nbsp;&nbsp;&nbsp;
                    <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">退号</button>&nbsp;&nbsp;&nbsp;
                    <button type="button" class="btn btn-success" id="delPro2">导出Excel</button>
                </div>
            </th>
        </tr>
    </table>
</form>
</body>
</html>

<script>
    // 翻页并加载数据
    $(function () {
        loadData();
        $("#firstPage").click(function () {
            if (($(this).attr("class")) == 'disabled')
                return;
            let num = $(this).attr("name");
            $("input[name='pageNum']").val(num);
            loadData();
        });

        $("#prePage").click(function () {
            if (($(this).attr("class")) == 'disabled')
                return;
            let num = $(this).attr("name");
            $("input[name='pageNum']").val(num);
            loadData();
        });

        $("#nextPage").click(function () {
            if (($(this).attr("class")) == 'disabled')
                return;
            let num = $(this).attr("name");
            $("input[name='pageNum']").val(num);
            loadData();
        });

        $("#lastPage").click(function () {
            if (($(this).attr("class")) == 'disabled')
                return;
            let num = $(this).attr("name");
            $("input[name='pageNum']").val(num);
            loadData();
        });
    });

    //填充分页信息
    function fillPageData(pageInfo) {
        //填充信息
        $("#total").html(pageInfo.total);
        $("#pages").html(pageInfo.pages);
        $("input[name='pageNum']").val(pageInfo.pageNum);
        $("select[name='pageSize']").val(pageInfo.pageSize);
        //设置按钮的属性值和样式
        $("#firstPage").attr("name", 1);
        $("#prePage").attr("name", pageInfo.prePage);
        $("#nextPage").attr("name", pageInfo.nextPage);
        $("#lastPage").attr("name", pageInfo.pages);

        $("#firstPage").removeClass("disabled");
        $("#prePage").removeClass("disabled");
        $("#nextPage").removeClass("disabled");
        $("#lastPage").removeClass("disabled");

        if (pageInfo.isFirstPage) {//如果是第一页：上一页和首页禁用
            $("#firstPage").addClass("disabled");
            $("#prePage").addClass("disabled");
        }
        if (pageInfo.isLastPage) {//如果已经是最后一页：下一页和末页禁用
            $("#nextPage").addClass("disabled");
            $("#lastPage").addClass("disabled");
        }
    }

    String.prototype.GetValue = function (para) {
        let reg = new RegExp("(^|&)" + para + "=([^&]*)(&|$)");
        let r = this.substr(this.indexOf("\?") + 1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }

    //加载数据
    function loadData() {
        let url = document.location.toString();
        let pageNum = url.GetValue("pageNum");
        let pageSize = url.GetValue("pageSize");
        if (pageNum != null && $("input[name='pageNum']").val() != null) {
            $("input[name='pageNum']").val(pageNum);
        }
        if (pageSize != null && $("select[name='pageSize']").val() != null) {
            $("select[name='pageSize']").val(pageSize);
        }

        $.ajax({
            type: "GET",
            url: "/register/list",
            data: $("#myForm").serialize(),//主要是分页和多条件参数数据
            dataType: "json",
            success: function (vo) {
                //alert( "Data Saved: " + vo );
                let list = vo.pageInfo.list;
                if (list.length == 0) {
                    alert("很抱歉！无法找到相关数据");
                }
                let str = "";
                for (let i = 0; i < list.length; i++) {
                    let obj = list[i];
                    let re_id = obj.re_id;
                    let d_name = obj.doctor.d_name == null ? '' : obj.doctor.d_name;
                    let re_createTime = obj.re_createTime == null ? '' : obj.re_createTime;
                    let d_keshi = obj.doctor.d_keshi == null ? '' : obj.doctor.d_keshi;
                    let re_state = "";
                    if (obj.re_state == 0) {
                        re_state = "已挂号";
                    } else if (obj.re_state == 1) {
                        re_state = "已住院";
                    } else if (obj.re_state == 2) {
                        re_state = "已出院";
                    } else if (obj.re_state == 3) {
                        re_state = "已退号";
                    }

                    let btnStr = "";
                    if (obj.re_state == 0) {
                        btnStr = '<button type="button" name="infoBtn" class="btn btn-sm btn-success" onclick="registerInfo(' + re_id + ')" >详情</button>&nbsp;' +
                            '<button type="button" name="updateBtn" class="btn btn-sm btn-info" onclick="update(' + re_id + ')">更改</button>&nbsp;' +
                            '<button type="button" name="deleteBtn" class="btn btn-sm btn-danger" onclick="deleteInfo(' + re_id + ')">退号</button>';
                    } else if (obj.re_state == 1) {
                        btnStr = '<button type="button" name="infoBtn" class="btn btn-sm btn-success" onclick="registerInfo(' + re_id + ')" >详情</button>&nbsp;' +
                            '<button type="button" name="updateBtn" class="btn btn-sm btn-info" onclick="update(' + re_id + ')">更改</button>&nbsp;';
                    } else {
                        btnStr = '<button type="button" name="infoBtn" class="btn btn-sm btn-success" onclick="registerInfo(' + re_id + ')" >详情</button>&nbsp;';
                    }

                    str += '<tr>' +
                        '            <td><input type="checkbox" name="check" value="' + re_id + '"/></td>' +
                        '            <td>' + re_id + '</td>' +
                        '            <td>' + d_name + '</td>' +
                        '            <td>' + re_createTime + '</td>' +
                        '            <td>' + d_keshi + '</td>' +
                        '            <td>' + re_state + '</td>' +
                        '            <td>' + btnStr + '</td>' +
                        '</tr>'
                }
                $("#tboby").html(str);
                //填充分页数据
                fillPageData(vo.pageInfo);
            }
        });
    }

    // 详情按钮
    function registerInfo(id) {
        window.location.href = "/pages/registration/look.jsp?re_id=" + id;
    }

    // 更改按钮
    function update(id) {
        window.location.href = "/registration/edit.html?re_id=" + id;
    }

    // 退号按钮
    function deleteInfo(id) {
        if (confirm("确定要退号吗?")) {
            //发起异步请求
            $.ajax({
                type: "POST",
                url: "/register/" + id, //RESTful风格的API定义
                data: "_method=DELETE",
                success: function (vo) {
                    if (vo.code == 200) {
                        loadData();
                    } else {
                        alert("删除失败！" + vo.msg);
                    }
                }
            });
        }
    }

    // 批量退号
    function deleteInfo2(id) {
        //发起异步请求
        $.ajax({
            type: "POST",
            url: "/register/" + id, //RESTful风格的API定义
            data: "_method=DELETE",
            success: function (vo) {
                if (vo.code == 200) {
                    loadData();
                } else {
                    alert("删除失败！" + vo.msg);
                }
            }
        });
    }


</script>

<script type="text/javascript">
    // 跳转到新增挂号信息页面
    $(function () {
        $('#newNav').click(function () {
            window.location.href = "add.jsp";
        });
    });

    function checkAll2() {
        let alls = document.getElementsByName("check");
        let ch = document.getElementById("checkall");
        if (ch.checked) {
            for (let i = 0; i < alls.length; i++) {
                alls[i].checked = true;
            }
        } else {
            for (let i = 0; i < alls.length; i++) {
                alls[i].checked = false;
            }
        }
    }


    function delAll() {
        let alls = document.getElementsByName("check");
        let ids = new Array();
        for (let i = 0; i < alls.length; i++) {
            if (alls[i].checked) {
                ids.push(alls[i].value);
            }
        }
        if (ids.length > 0) {
            if (confirm("确认操作?")) {
                for (let i = 0; i < ids.length; i++) {
                    deleteInfo2(ids[i]);
                }
            }
        } else {
            alert("请选中要操作的项");
        }
    }
</script>