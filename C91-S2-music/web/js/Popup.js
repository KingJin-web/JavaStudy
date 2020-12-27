document.write("<script src='../dist/mDialogMin.js'></script>");
document.write(' <link href="../dist/dialog.css" rel="stylesheet">')

function myAlert(text) {
    Dialog.init('<p style=" margin:8px 0;width:100%;padding:11px 8px;font-size:15px; solid #999;">' + text + '</p>', {
        title: '提示',
        button: {
            确定: function () {
                Dialog.close(this);
                if (text === "登陆成功") {
                    return 1;
                } else {
                    return 0;
                }
            },
            取消: function () {

                Dialog.close(this);
                return 0;
            }
        },
        time: 3000,
    });
}