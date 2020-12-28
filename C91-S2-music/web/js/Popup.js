document.write("<script type='text/javascript' src='dist/mDialogMin.js'></script>");
document.write('<link type="text/css" href="dist/dialog.css" rel="stylesheet">')
document.write("<script type='text/javascript' src='layer/layer.js'></script>");
document.write("<script type='text/javascript' src='js/jquery-3.5.1.js'></script>");


function myAlert(text) {
    Dialog.init('<p style=" margin:8px 0;width:100%;padding:11px 8px;font-size:15px; solid #999;">' + text + '</p>', {
        title: '提示',
        button: {
            确定: function () {
                Dialog.close(this);

            },
            取消: function () {
                Dialog.close(this);
            }
        },
        time: 3000,
    });
}

function alertLogin(text) {
    if (text === "登陆成功") {
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
 * //https://layer.layui.com/
 * https://layer.layui.com/test/more.html
 * https://www.layui.com/alone.html
 * https://layer.layui.com/hello.html
 * @param text 提示内容
 * @param path 跳转页面路径
 * @param success 成功的提示
 */
function alertLayer(text, path, success) {
    if (text === success) {
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
    if (text === "修改成功") {
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
 * 弹出式广告
 */
function alertAdv() {
    layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '300px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,resize: false
        ,btn: ['火速围观', '残忍拒绝']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' +
            '<h2>云服务器ECS </h2><br>云服务器12月钜惠，新用户低至0.55折， 1核2G轻量服务器首年96元（可优惠续费3次），助您轻松上云</div>'
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').attr({
                href: 'https://www.aliyun.com/1111/new?userCode=t6jlywqr'
                ,target: '_blank'
            });
        }
    });
}

function myAlert(text, path, success) {
    Dialog.init('<p style=" margin:8px 0;width:100%;padding:11px 8px;font-size:15px; solid #999;">' + text + '</p>', {
        title: '提示',
        button: {
            确定: function () {
                if (text === success) {
                    window.location.href = path;
                }
                Dialog.close(this);
            },
            取消: function () {
                Dialog.close(this);
            }
        },
    });
}