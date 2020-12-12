## HTML
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><title>Title</title></title>
</head>
<body>
<h1>我的第一个标题</h1>
<p>我的第一个段落。</p>
<hr>
<br>
</body>
</html>
```   


### 分析
    <!DOCTYPE html> 声明为 HTML5 文档
    <html> 元素是 HTML 页面的根元素 该标签的结束标志为</html>
    <head> 元素包含了文档的元（meta）数据，如 <meta charset="utf-8"> 定义网页编码格式为 utf-8。
    <title> 元素描述了文档的标题  该标签的结束标志为</body>
    <body>标签定义文档的主体，即网页可见的页面内容，该标签的结束标志为</body>。
    <h1>标签作为一个标题使用，该标签的结束标志为</h1>。
    <p>标签作为一个段落显示，该标签的结束标志为</p>。（中间的所有字符都会显示为一行）
    <hr> 分割线
    <br> 换行
    
    无论你用了多少空格（包括空格字符，包括换行），当渲染这些代码的时候，
    HTML 解释器会将连续出现的空格字符减少为一个单独的空格符。



 ### 特点
 HTML 标记标签通常被称为 HTML 标签 (HTML tag)
 
  * HTML 标签是由尖括号包围的关键词，比如\<html>
  * HTML 标签通常是成对出现的，比如\<b>和\</b>
  * 标签对中的第一个标签是开始标签，第二个标签是结束标签
  * 开始和结束标签也被称为开放标签和闭合标签
  * ` <标签>内容</标签> `

## HTML 链接(超链接)
HTML 链接是通过标签\<a>来定义的。a标签，也叫anchor（锚点）元素，
既可以用来链接到外部地址实现页面跳转功能，也可以链接到当前页面的某
部分实现内部导航功能。

```html
<a href="https://www.baidu.com/">访问百度</a>
<a href="../../index.html">去登陆</a> <!支持相对路径  .. 表示上级目录-->
<a href="表格控件.html">表格控件</a>
```
<a href="https://www.baidu.com/">访问百度</a>

<a href="index.html">去登陆</a> <!--访问内部-->

<a href="表格控件.html">表格控件</a>

## HTML 图像(显示图片)
HTML 图像是通过标签\<img>来定义的。使用img元素来为你的网站添加图片
，使用src 属性指向一个图片的具体地址。
```html
<img src="../img/2Q__.jpg" width="560" height="300">
<img src="https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3781677723,3696527582&fm=26&gp=0.jpg" width="560" height="300">
<img alt="替代文字" src="https://media.st.dl.pinyuncloud.com/steam/apps/582160/header.jpg?t=1602601184" width="560" height="300">
```
![](../img/2Q__.jpg "鬼刀")
<img src="https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3781677723,3696527582&fm=26&gp=0.jpg" width="560" height="300">
<img alt="替代文字" src="https://media.st.dl.pinyuncloud.com/steam/apps/582160/header.jpg?t=1602601184" width="560" height="300">

## HTML表单
```html
表单
		输入框，单选框，多选框。。。
		作用： 将用户数据提交到服务器
		构成：
		<form action="提交的地址（跳转的地址）" method="提交方法" >
			用户操作的控件：文本框，单选框，多选框，下拉框，文件上传，多行文本框。。。
			注意： 每个输入控件必须提供 name 属性
				由name属性的控件，会将用户输入的值提交给服务器
		</form>

```
*实例*
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表单</title>
</head>
<body>
<form action="作业/index.html">
    <label>
        账号：<input>
    </label><br>
    <label>
        密码：<input type="password">
    </label><br>
    <label>
        性别：<input type="radio" name="sex">男<input type="radio" name="sex">女
    </label><br>
    <label>
        爱好：<input type="checkbox" name="like">篮球<input type="checkbox" name="like">游戏<input type="checkbox" name="like">电影
    </label><br>
    <label>
        邮箱：<input type="email">
    </label><br>
    <label>
        年龄：<input type="number">
    </label><br>
    学历
    <label>
        <select name="edu">
            <option>小学</option>
            <option>中学</option>
            <option>高中</option>
            <option>大学</option>
        </select>
    </label><br>
    <label>
        自我介绍
        <textarea rows="10" cols="50"></textarea>
    </label><br>
    <input type="submit" value="注册"> <!--提交按钮-->
    <input type="button" value="按钮"> <!--普通按钮-->
    <input type="reset" value="重置"> <!--重置输入-->
</form>
</body>
</html>
```