document.write("<script type='text/javascript' src='dist/mDialogMin.js'></script>");
document.write('<link type="text/css" href="dist/dialog.css" rel="stylesheet">')
document.write("<script type='text/javascript' src='layer/layer.js'></script>");


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

//https://layer.layui.com/
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

function alertSave(text) {
    if (text === "保存成功") {
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