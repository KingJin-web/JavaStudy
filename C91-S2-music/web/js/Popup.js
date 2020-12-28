document.write("<script type='text/javascript' src='dist/mDialogMin.js'></script>");
document.write('<link type="text/css" href="dist/dialog.css" rel="stylesheet">')


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