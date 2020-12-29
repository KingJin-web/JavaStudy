// document.write("<script type='text/javascript' src='dist/mDialogMin.js'></script>");
// document.write('<link type="text/css" href="dist/dialog.css" rel="stylesheet">')
document.write("<script type='text/javascript' src='layer/layer.js'></script>");
document.write("<script type='text/javascript' src='js/jquery-3.5.1.js'></script>");
document.write("<script type='text/javascript' src='layui/layui.all.js'></script>");
document.write("<script type='text/javascript' src='js/vue.js'></script>");
document.write('<link rel="stylesheet" href="layui/css/layui.css"  media="all">');

//
// function myAlert(text) {
//     Dialog.init('<p style=" margin:8px 0;width:100%;padding:11px 8px;font-size:15px; solid #999;">' + text + '</p>', {
//         title: '提示',
//         button: {
//             确定: function () {
//                 Dialog.close(this);
//
//             },
//             取消: function () {
//                 Dialog.close(this);
//             }
//         },
//         time: 3000,
//     });
// }

// function myAlert(text, path, success) {
//     Dialog.init('<p style=" margin:8px 0;width:100%;padding:11px 8px;font-size:15px; solid #999;">' + text + '</p>', {
//         title: '提示',
//         button: {
//             确定: function () {
//                 if (text === success) {
//                     window.location.href = path;
//                 }
//                 Dialog.close(this);
//             },
//             取消: function () {
//                 Dialog.close(this);
//             }
//         },
//     });
// }

function alertMy(text) {
    if (text.includes("成功")) {
        layer.alert(text, {
            icon: 1,
            skin: 'layer-ext-moon'
        })
    } else {
        layer.alert(text, {
            icon: 3,
            skin: 'layer-ext-moon'
        })
    }
}

/**
 * 如果没有登录
 * 请先登录，跳转登录界面
 * 3秒后自动跳转
 */
function gotoLogin() {
    layer.confirm("请先登录 !", {
        icon: 2,
        shade: 1,
        btn: ['确认'], //按钮
        // window.location.href = "login.html";
    }, function () {
        window.location.href = "login.html";
    })


}


/**
 * //https://layer.layui.com/
 * https://layer.layui.com/test/more.html
 * https://www.layui.com/alone.html
 * https://layer.layui.com/hello.html
 * @param text 提示内容
 * @param path 跳转页面路径
 * @param success 成功的提示
 */
function alertLayer(text, path) {
    if (text.includes("成功")) {
        layer.confirm(text, {
            icon: 1,
            btn: ['确认'] //按钮
        }, function () {
            window.location.href = path;
        })

    } else {
        layer.alert(text, {
            icon: 3,
            skin: 'layer-ext-moon'
        })
    }
}

/**
 * 保存用户信息 提示弹窗 以及延迟加载
 * @param data 后台回调的信息
 */
function alertSave(data) {
    this.data = data;
    layer.load(0, {shade: false, time: 2000});
    setTimeout(" var text = data;alertSave2(text)", 1000);
}

function alertSave2(text) {

    if (text.includes("成功")) {
        layer.alert(text, {
            icon: 1,
            skin: 'layer-ext-moon'
        })
    } else {
        layer.alert(text, {
            icon: 3,
            skin: 'layer-ext-moon'
        })
    }
}

function alertShare() {
    // var pass;
    // layer.prompt({title: '输入任何口令，并确认', formType: 1}, function (pass, index) {
    //     layer.close(index);
    //     layer.prompt({title: '随便写点啥，并确认', formType: 2}, function (text, index) {
    //         layer.close(index);
    //         layer.msg('演示完毕！您的口令：' + pass + '<br>您最后写下了：' + text);
    //     });
    // });
    layer.open({
        type: 1,
        title: "分享歌曲",
        closeBtn: 1,
        shadeClose: true,
        isOutAnim: true,
        area: '400px',
        shade: 0.7,
        id: 'LAY_layuipro',//设定一个id，防止重复弹出,
        resize: false,
        btnAlign: 'c',
        moveType: 1,//拖拽模式，0或者1

        content:
            '<div id="layuiMy">' +
            '<form class="layui-form">'+
            '<div class="layui-form-item">' +
            '    <label class="layui-form-label">标题/歌曲名/专辑名</label>' +
            '    <div class="layui-input-block">' +
            '      <input type="text" name="tname" v-model="tname"  required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
            '    </div>' +
            ' </div>' +
            '<textarea name="" required lay-verify="required" placeholder="请输入" class="layui-textarea"></textarea>' +
            '<button class="layui-btn" @click="print" lay-submit lay-filter="formDemo">立即提交</button>' +
            '</form>'+

            '</div>' +
            '<script type="text/javascript">' +
            ' var vue = new Vue({\n' +
            '                el: "#layuiMy",\n' +
            '                data: {\n' +
            '                    tname: "",\n' +
            '                },\n' +
            '                methods: {\n' +
            '                    print(){\n' +
            '                        console.log(this.tname)\n' +
            '                    }\n' +
            '                }\n' +
            '\n' +
            '            })' +
            '</script>',

        success: function (layero, index) {


            // var vue = new Vue({
            //     el: "#layuiMy",
            //     data: {
            //         tname: "",
            //     },
            //     methods: {
            //         print(){
            //             console.log(this.tname)
            //         }
            //     }
            //
            // })

        }
    });

}

function changePwd() {
    layer.open({
        type: 1,
        title: "修改密码",
        closeBtn: 1,
        shadeClose: true,
        isOutAnim: true,
        area: '400px',
        shade: 0.7,
        id: 'LAY_layuipro',//设定一个id，防止重复弹出,
        resize: false,
        btnAlign: 'c',
        moveType: 1,//拖拽模式，0或者1

        content: '<div style="padding:50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><div class="layui-form"><div class="layui-form-item">' +
            '<div class="layui-form-label">旧密码</div>' +
            '<div class="layui-input-inline">' +
            '<input id="old-pass" style="color: #0C0C0C" class="layui-input" type="password" placeholder="旧密码">' +
            '</div></div><div class="layui-form-item">' +
            '<div class="layui-form-label">新密码</div>' +
            '<div class="layui-input-inline">' +
            '<input style="color: #0C0C0C" id="new-pass" class="layui-input" type="password" placeholder="新密码">' +
            '</div></div>' +
            '<div class="layui-form-item"> ' +
            '<div style="float: left;display:block;padding: 9px 12px;width: auto;font-weight: 400;text-align:right;">确认密码</div>' +
            '<div class="layui-input-inline"><input style="color: #0C0C0C" class="layui-input" id="sure-pass" type="password" placeholder="确认密码">' +
            '</div></div></div></div> ' +
            '<div class="btn-cont"><button class="pass cancel-btn">取消</button>' +
            '<button class="pass ok-btn">确认</button> </div> </div>',

        success: function (layero, index) {
            var btn = layero.find('.btn-cont');
            var oldPass = layero.find('#old-pass');
            var newPass = layero.find('#new-pass');
            var surePass = layero.find('#sure-pass');

            //取消按钮事件
            btn.find('.cancel-btn').click(function () {
                layer.close(index);
            });

            //确认按钮点击事件
            btn.find('.ok-btn').click(function () {

                //获取输入框内容方式一
                console.log("oldPass=" + $(oldPass).val());
                console.log("newPass=" + $(newPass).val());
                console.log("surePass=" + $(surePass).val());

                //获取输入框内容方式二
                $(layero).find("input").each(function (i, v) {
                    console.log("index=" + i + "====" + "value=" + $(v).val());
                });

                layer.close(index);
            })
        }
    });


}

/**
 * 弹出式广告
 */
function alertAdv() {
    layer.open({
        type: 1
        ,
        title: false //不显示标题栏
        ,
        closeBtn: false
        ,
        area: '300px;'
        ,
        shade: 0.8
        ,
        id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,
        resize: false
        ,
        btn: ['火速围观', '残忍拒绝']
        ,
        btnAlign: 'c'
        ,
        moveType: 1 //拖拽模式，0或者1
        ,
        content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' +
            '<h2>云服务器ECS </h2><br>云服务器12月钜惠，新用户低至0.55折， 1核2G轻量服务器首年96元（可优惠续费3次），助您轻松上云</div>'
        ,
        success: function (layero) {
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').attr({
                href: 'https://www.aliyun.com/1111/new?userCode=t6jlywqr'
                , target: '_blank'
            });
        }
    });
}
