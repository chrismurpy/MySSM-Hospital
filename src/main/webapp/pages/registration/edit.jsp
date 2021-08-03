<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>挂号更改</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
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
		$('#backid').click(function(){
				window.location.href="index.jsp";
		 });
    });
    </script>
</head>
<body>
<form action="index.jsp" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td><input type="text" name="pname" value="陆小凤"/></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">身份证号</td>
        <td><input type="text" name="pname" value="21324324324"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">挂号费</td>
        <td><input type="text" name="pname" value="5"/>元</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td><input type="text" name="pname" value="453253453"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td><input type="text" name="pname" value="13543235678"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
        <td><input type="radio" name="pname0" value="" checked/>否&nbsp;&nbsp;&nbsp;<input type="radio" name="pname0" value=""/>是</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td><input type="radio" name="pname" value="" checked/>男&nbsp;&nbsp;&nbsp;<input type="radio" name="pname" value=""/>女</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td><input type="text" name="pname" value="33"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">职业</td>
        <td><input type="text" name="pname" value="狗仔队"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初复诊</td>
        <td><input type="radio" name="pname1" value="" checked/>初诊&nbsp;&nbsp;&nbsp;<input type="radio" name="pname1" value=""/>复诊</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所挂科室</td>
        <td><select><option>急诊科</option><option>骨科</option><option>血液科</option></select></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
        <td><select><option>程俊</option><option>欧阳雨露</option><option>王博</option></select></td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td><textarea>此人疑拟有精神病</textarea></td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>