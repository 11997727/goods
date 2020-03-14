<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 引入Bootstrap核心文件 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery(Bootstrap的JavaScript插件需要引入jQuery，务必在bootstrap.min.js之前引入) -->
    <script src="js/jquery.min.js"></script>

    <!-- 包括所有已编译的JS插件 -->
    <script src="js/bootstrap.min.js"></script>

</head>

<body>


<div class="container" style="font-family:微软雅黑;font-size:larger">
    <div class="page-header">
        <h2 align="center">商品列表</h2>
    </div>
    <div class="col-md-offset-2 col-md-8">


<#--        <button type="button" class="btn btn-primary" data-target="#myModal" data-toggle="modal">添加</button>-->
<#--        <!-- 模态框（Modal） &ndash;&gt;-->
<#--        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">-->
<#--            <div class="modal-dialog">-->
<#--                <div class="modal-content">-->
<#--                    <div class="modal-header">-->
<#--                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">-->
<#--                            &times;-->
<#--                        </button>-->
<#--                        <h4 class="modal-title" id="myModalLabel">-->
<#--                            添加-->
<#--                        </h4>-->
<#--                    </div>-->
<#--                    <div class="modal-body">-->
<#--                        <form class="form-horizontal" role="form">-->
<#--                        <div class="form-group">-->
<#--                            <label for="role" class="col-sm-2 control-label">角色</label>-->
<#--                            <div class="col-sm-10">-->
<#--                            <label class="checkbox-inline">-->
<#--                                <input type="checkbox" id="role" name="role" value="1"> 超级管理员-->
<#--                            </label>-->
<#--                            <label class="checkbox-inline">-->
<#--                                <input type="checkbox" name="role" value="2"> 普通管理员-->
<#--                            </label>-->
<#--                            </div>-->

<#--                        </div>-->
<#--                        <div class="form-group">-->
<#--                            <label for="username" class="col-sm-2 control-label">账号</label>-->
<#--                            <div class="col-sm-10">-->
<#--                                <input type="text" class="form-control" name="username" id="username" placeholder="请输入账号">-->
<#--                            </div>-->
<#--                        </div>-->
<#--                            <div class="form-group">-->
<#--                                <label for="phone" class="col-sm-2 control-label">电话</label>-->
<#--                                <div class="col-sm-10">-->
<#--                                    <input type="text" class="form-control" name="phone" id="phone" placeholder="请输入电话">-->
<#--                                </div>-->
<#--                            </div>-->
<#--                        <div class="form-group">-->
<#--                            <label for="password" class="col-sm-2 control-label">密码</label>-->
<#--                            <div class="col-sm-10">-->
<#--                                <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码">-->
<#--                            </div>-->
<#--                        </div>-->

<#--                        </form>-->
<#--                    </div>-->

<#--                    <div class="modal-footer">-->
<#--                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭-->
<#--                        </button>-->
<#--                        <button type="button"  id="add" class="btn btn-primary">-->
<#--                            提交更改-->
<#--                        </button>-->
<#--                    </div>-->
<#--                </div><!-- /.modal-content &ndash;&gt;-->
<#--            </div><!-- /.modal &ndash;&gt;-->
<#--        </div>-->





        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel2">
                            秒杀抢购
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="gtitle" class="col-sm-2 control-label">标题</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="gtitle" id="gtitle">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="gname" class="col-sm-2 control-label">商品名称</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="gname" id="gname">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="stock" class="col-sm-2 control-label">库存</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="stock" id="stock">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="originalPrice" class="col-sm-2 control-label">原价</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="originalPrice" id="originalPrice">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="price" class="col-sm-2 control-label">折扣价</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="price" id="price">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="gdesc" class="col-sm-2 control-label">商品描述</label>
                                <div class="col-sm-10">
                                <textarea class="form-control" rows="3" name="gdesc" id="gdesc"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="uid" class="col-sm-2 control-label">UID</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="uid" id="uid">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="button" id="updateBtn" class="btn btn-primary">
                            立即购买
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>



        <#if map.code==2001>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <td>名称</td>
                    <td>标题</td>
                    <td>原价</td>
                    <td>限价</td>
                    <td>操作</td>
                </tr>
                </thead>
                <#list map.data as good>
                    <tr>
                        <td>${good.gname}</td>
                        <td>${good.gtitle}</td>
                        <td>${good.originalPrice}</td>
                        <td>${good.price}</td>
                        <td>
                            <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal2" onclick="query(${good.gid?c})">查看</button>
                        </td>
                    </tr>
                </#list>
            </table>
        <#else >
            <span>暂无数据</span>
        </#if>


    </div>

</div>



</body>
<script type="text/javascript">
    $(function () {

    })
    var $gid
    function query(gid){
        $gid=gid.toString()
        $("#updateBtn").attr("disabled", false);
            $.ajax({
                url:"/queryGoodByID",
                data:{
                    "gid":gid,
                },
                dataType:"json",
                type:"post",
                success:function (res) {
                   var good=JSON.parse(res.data)
                    var stock=JSON.parse(res.stock)
                    $('#gtitle').val(good.gtitle)
                    $('#gname').val(good.gname)
                    $('#gdesc').val(good.gdesc)
                    $('#price').val(good.price)
                    $('#stock').val(stock)
                    $('#originalPrice').val(good.originalPrice)
                    if(stock.toString()=='0'){
                        $("#updateBtn").attr("disabled", true);
                    }
                }

            })
    }

    $('#updateBtn').click(function () {
        var $uid = $('#uid').val();
        if($uid==''){
            alert("请输入UID")
        }else{
            $.ajax({
                url:"/buy",
                data:{
                    "uid":$uid,
                    "gid":$gid
                },
                dataType:"json",
                type:"post",
                success:function (res) {
                    alert(res.msg)
                    $('#updateBtn').attr("data-dismiss","modal");
                    window.location.reload()
                }
            })

        }
    })
    var websocket=null;

    if ('WebSocket' in window){
        websocket=new WebSocket("ws://localhost:8080/socket");
    } else {
        alert("这个浏览器不支持");
    }

    websocket.onopen=function (event) {
        // alert("连上了");
    }

    websocket.onclose=function (event) {
        // alert("关闭了");
    }

    websocket.onerror=function(event){
        // alert("传输错误");
    }

    websocket.onmessage=function (event) {
        alert(event.data)
    }

    function send() {
        var  msg=document.getElementById("words").value;
        websocket.send(msg);
    }
</script>
</html>
