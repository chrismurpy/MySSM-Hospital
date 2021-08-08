
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <meta charset="UTF-8">
<%--    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>--%>
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


  <%--  <script type="text/javascript">
     $(function () {
		$('#newNav').click(function(){
				window.location.href="addUser.html";
		 });
    });
	
	
    function checkall(){
			var alls=document.getElementsByName("check");
			var ch=document.getElementById("checkall");
			if(ch.checked){
				for(var i=0;i<alls.length;i++){
					alls[i].checked=true;	
				}	
			}else{
				for(var i=0;i<alls.length;i++){
					alls[i].checked=false;	
				}	
			}
		}
		function delAll(){
			var alls=document.getElementsByName("check");
			var ids=new Array();
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked){
					ids.push(alls[i].value);
				}		
			}
			if(ids.length>0){
				if(confirm("确认删除?")){
					alert("删除成功!");
				}
			}else{
				alert("请选中要删除的项");
			}
		}
    </script>--%>
</head>
<body>
<%--<form id="userForm" class="form-inline definewidth m20"  method="post">--%>
<form id="userForm" class="form-horizontal"  method="post">

    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">用户账户：</td>
            <td width="10%" ><input type="text" name="u_LoginName" value=""/></td>
            <td class="tableleft" >
                <button type="button" onclick="loadData()" class="btn btn-info">查询</button>
            </td>
        </tr>
    </table>

    <table class="table table-bordered table-hover definewidth m10">
        <thead>
        <tr>
            <th><input type="checkbox" id="checkAll" onclick="checkAll2();"></th>
            <th>用户账户</th>
            <th>真实姓名</th>
            <th>角色</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody id="tbody">
        <tr>
            <td><input type="checkbox" name="check"></td>
            <td>admin</td>
            <td>管理员</td>
            <td>管理员</td>
            <td style="vertical-align:middle;">
                <a href="editUser.jsp">编辑</a>&nbsp;&nbsp;&nbsp;
                <a href="javascript:alert('删除成功！');">删除</a>
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
                    <button type="button" class="btn btn-success" id="newNav">添加用户</button>&nbsp;&nbsp;&nbsp;
                    <button type="button" class="btn btn-success" id="delPro" onclick="delAll();">删除选中</button>&nbsp;&nbsp;&nbsp;
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
            url: "/User/index",
            data: $("#userForm").serialize(),//主要是分页和多条件参数数据
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
                    let u_LoginName = obj.u_LoginName == null ? '' : obj.u_LoginName;
                    let u_trueName = obj.u_trueName == null ? '' : obj.u_trueName;
                    let r_name = obj.role.r_name == null ? '' : obj.role.r_name;
                    let u_state = obj.u_state == null ? '' : obj.u_state;

                    let btnStr = "";
                    if (u_state == 0) {
                        btnStr = '<button type="button" name="updateBtn" class="btn btn-sm btn-info" onclick="updateUser(' + u_LoginName + ')">编辑</button>&nbsp;' +
                               '<button type="button" name="deleteBtn" class="btn btn-sm btn-danger" onclick="deleteUser(' + u_LoginName + ')">删除</button>';
                    } else {
                        btnStr = '<button name="deleted" class="btn btn-sm btn-danger disabled">已删除</button>';
                    }
                    str += '<tr>' +
                        '            <td><input type="checkbox" name="check"/></td>' +
                        '            <td>' + u_LoginName + '</td>' +
                        '            <td>' + u_trueName + '</td>' +
                        '            <td>' + r_name + '</td>' +
                        '            <td>' + btnStr + '</td>' +
                        '</tr>'

                }
                $("#tbody").html(str);
                //填充分页数据
                fillPageData(vo.pageInfo);
            }
        });
    }

    // 编辑按钮
    function updateUser(u_id) {
        window.location.href = "/pages/User/editUser.jsp?u_LoginName=" + u_id;
    }


    // 删除按钮
    function deleteUser(u_id) {
        if (confirm("确定要删除用户吗?")) {
            //发起异步请求
            $.ajax({
                type: "POST",
                url: "/User/" + u_id, //RESTful风格的API定义
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

    $(function () {
        $('#newNav').click(function(){
            window.location.href="addUser.jsp";
        });
    });

    function checkAll2() {
        let alls = document.getElementsByName("check");
        let ch = document.getElementById("checkAll");
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





</script>