<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>人民医院信息管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/pages/assets/css/dpl-min.css" rel="stylesheet" type="text/css"/>
    <link href="/pages/assets/css/bui-min.css" rel="stylesheet" type="text/css"/>
    <link href="/pages/assets/css/main-min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform">
            <div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div>
        </div>
        <ul id="J_Nav" class="nav-list ks-clear" style="float:left">
            <li style=" color:#fff; font-size:20px; margin-top:10px; margin-left:20px;">人民医院管理平台</li>
        </ul>
        <div style="float:right; color:#fff;font-size: 15px;padding-top: 10px">
            欢迎您，<span class="dl-log-user">${username}</span>
            <a href="/logout" title="退出系统" class="dl-log-quit">[退出]</a></div>
    </div>

    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
</div>



<%--<c:forEach items="menuList" var="m">

 ${m.m_url}

</c:forEach>--%>



<script type="text/javascript" src="/pages/assets/js/jquery-1.6.js"></script>
<script type="text/javascript" src="/pages/assets/js/bui.js"></script>
<script type="text/javascript" src="/pages/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="/pages/assets/js/config-min.js"></script>


<script>
    BUI.use('common/main', function () {
        var config = [
            {
                id: '1', menu: [
                    {
                        text: '快速通道', items: [
                            // {id: '1', text: '挂号信息管理', href: '/pages/registration/list.jsp'},
                            // {id: '2', text: '住院办理', href: '/pages/hospital/index.html'},
                            // {id: '3', text: '住院结算', href: '/pages/hospital/account.html'},
                            // {id: '4', text: '在院发药', href: '/pages/hospital/dispensing.html'},
                            // {id: '5', text: '药品管理', href: '/pages/medicine/index.html'},
                            // {id: '6', text: '检查收费项目登记', href: '/pages/hospital/charge2.html'},
                            // {id: '7', text: '收费项目管理', href: '/pages/hospital/charge.html'},
                            // {id: '8', text: '门诊医生管理', href: '/pages/doctor/index.html'},
                            // {id: '9', text: '用户管理', href: '/pages/User/index.html'},
                            // {id: '10', text: '角色管理', href: '/pages/Role/index.html'},
                            // {id: '11', text: '资源管理', href: '/pages/Resource/index.html'},
                            // {id: '12', text: '密码管理', href: '/pages/User/password.jsp'}
                            <c:forEach items="${menuList}" var="menu">
                            {
                                id: '${menu.m_id}',
                                text: '${menu.m_name}',
                                href: '${menu.m_url}',
                            },
                            </c:forEach>
                        ]
                    }
                ]
            }
        ];
        new PageUtil.MainPage({
            modulesConfig: config
        });
    });

</script>
</body>
</html>