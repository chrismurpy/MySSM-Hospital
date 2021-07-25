<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

                            {id: '2', text: '挂号信息管理', href: 'registration/index.jsp'},

                            {id: '5', text: '住院办理', href: 'hospital/index.jsp'},
                            {id: '8', text: '住院结算', href: 'hospital/account.html'},

                            {id: '7', text: '在院发药', href: 'hospital/dispensing.html'},
                            {id: '4', text: '药品管理', href: 'medicine/index.jsp'},

                            {id: '16', text: '检查收费项目登记', href: 'hospital/charge2.html'},
                            {id: '6', text: '收费项目管理', href: 'hospital/charge.html'},

                            /** 扩展
                             {id:'9',text:'月营业额统计',href:''},
                             {id:'10',text:'年营业额统计',href:''},
                             **/
                            {id: '3', text: '门诊医生管理', href: 'doctor/index.jsp'},
                            {id: '11', text: '用户管理', href: 'User/index.jsp'},
                            {id: '12', text: '角色管理', href: 'Role/index.jsp'},
                            {id: '13', text: '资源管理', href: 'Resource/index.jsp'},
                            {id: '13', text: '密码管理', href: 'User/password.jsp'}
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