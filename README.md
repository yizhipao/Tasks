## 开发工具，语言
### 一、node.js安装配置
1、读写文件

`//使用require方法加载核心fs核心模块
var fs=require('fs')

//读取文件
//2、读取文件
//第一个参数就是要读取的文件路径
//第二个参数是一个回调函数
//成功
//data 数据
// error null
// 失败
// data null
// error 错误对象
fs.readFile('./demo.js' ,function(error,data){
   if(error){
        console.log('运行失败') 
    }
    else{
        console.log(data.toString()) //运行成功在控制台打印文件内容
    }
})

//写入文件
//第一个参数就是要写入的文件路径
//第二个参数是文件内容
//第三个参数是一个回调函数
fs.writeFile('./demo.js' ,'大家好',function(error){
    if(error){
        console.log('运行失败') 
    }
    else{
        console.log(‘运行成功’) //运行成功在控制台打印显示成功
    }
})`

2、简单的http服务
node中专门提供了一个核心模块：http
这个模块的职责就是编写服务器

`//1、创建对象
var http=require('http')

// 2、使用http.createServer()方法创建一个web服务器
// 返回一个server实例
var server = http.createServer()

//3、注册request请求事件
//当客户端的请求过来。就会自动触发服务器的request请求事件，然后执行第二个函数，回调处理函数
// request请求事件处理函数，需要接收两个参数：
// Request请求对象
// 请求对象可以用来获取客户端的一些请求信息，例如请求路径
// response响应对象
// 响应对象可以用来给客户端发送相应消息
server.on('request',function(request,response){
    console.log('收到请求,请求路径是：' + request.url)
// response对象有一个方法：write 可以用来给客户端发送响应数据
// write 可以使用多次，但是最后一定要使用end来结束响应，否则客户端会一直等待
response.write('hello')
response.end()
})

// 4、绑定端口号，启动服务器
 server.listen(234,function (request,response) {//端口号可以是1-65535的任意数字
    console.log('服务器启动成功，可以通过http://127.0.0.1:234/来访问')//或者http://localhost:234/
   })`
   
3、根据不同请求路径返回不同数据

`var http = require("http");
//步骤：
// 1、创建Server实例
// 2、监听request请求事件，设置请求处理函数
// 3、绑定端口号，启动服务

var server = http.createServer();

server.on("request", function(req, res) {
  console.log("收到请求,请求路径是：" + req.url);

  //根据不同的请求路径发送不同的响应结果
  //1、获取请求路径
  //req.url获取到的是端口号之后的那一部分路径
  //2、判断路径处理响应
  var url = req.url;
  if (url === "/") {
    res.end("please reset")
  } else if (url === "/index") {
    res.end("welcome to the index");
  } else {
    res.end("404 not found");
  }
});`
// 4、绑定端口号，启动服务器
`server.listen(234, function(request, response) {
  //端口号可以是1-65535的任意数字
  console.log("服务器启动成功，可以通过http://127.0.0.1:234/来访问"); //或者http://localhost:234/
});`

### 二、electron安装配置
#### 安装
在写好的node.js文件夹下安装electron
官方文档：https://electronjs.org/docs/tutorial/installation
- 通过命令行安装
npm install electron --save-dev
- 一般来说官网下载较慢，可以使用淘宝镜像下载
npm install -g cnpm --registry=https://registry.npm.taobao.org
- 使用镜像的npm改为cnpm，其余不变
ps：我自己安装electron的时候通过淘宝镜像安装的版本过低，但是官网安装下载速度又过慢
可以直接指定版本号下载，这样就行了
- 下载版本zip：

- 查看是否成功：

#### 使用
打开你要写node.js文件的那个文件夹
通过命令行进入此文件夹
1.	项目初始化
npm init
2.	配置package.json
`{
  "name": "wrt",    # 模块名（随便取）
  “version”: (1.0.0) ，
  "description": "a simple application", （项目描述，可写可不写）
  "main": "main.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "start": "electron ."
  },
  "author": "wrt",
  "license": "ISC" `
  
3.	main.js用于创建窗口和处理系统事件。
文件内容：

  `  // 引用electron依赖
    const electron = require('electron')
    // Module to control application life.  创建应用实例
    const app = electron.app
    // Module to create native browser window.      引用原生浏览器窗口，用于创建和控制浏览器窗口
    const BrowserWindow = electron.BrowserWindow

    const path = require('path')
    const url = require('url')

    // Keep a global reference of the window object, if you don't, the window will
    // be closed automatically when the JavaScript object is garbage collected.
    // 保存一个对于window对象的全局引用，如果你不这样做，当JavaScript对象被垃圾回收，window对象将关闭。
     let mainWindow

    function createWindow () {
    // Create the browser window.  创建浏览器窗口，并设置宽高 
     mainWindow = new BrowserWindow({width: 800, height: 600})

    // and load the index.html of the app.    加载应用的index.html
    mainWindow.loadURL(url.format({
    pathname: path.join(__dirname, 'index.html'),
    protocol: 'file:',
    slashes: true
    }))

    // Open the DevTools.   打开开发者工具  
    mainWindow.webContents.openDevTools()

    // Emitted when the window is closed.      当窗口被关闭时，触发这个事件
     mainWindow.on('closed', function () {
    // Dereference the window object, usually you would store windows     
    // in an array if your app supports multi windows, this is the time
    // when you should delete the corresponding element.

    // 取消引用window对象，如果你的应用支持多窗口的话，通常
    //  会把多个window对象存放在一个数组里面，与此同时，你应该删除相应的元素。
    mainWindow = null
    })
    }

    // This method will be called when Electron has finished
    // initialization and is ready to create browser windows.
    // Some APIs can only be used after this event occurs.
 
    // electron会在初始化后，准备创建浏览器窗口时调用这个函数，
    // 部分API在 ready事件出发后才能使用
    app.on('ready', createWindow)

    // Quit when all windows are closed.   当所有窗口关闭时推出  
    app.on('window-all-closed', function () {
    // On OS X it is common for applications and their menu bar
    // to stay active until the user quits explicitly with Cmd + Q
    if (process.platform !== 'darwin') {
    app.quit()
    }
    })

    app.on('activate', function () {
      // On OS X it's common to re-create a window in the app when the
      // dock icon is clicked and there are no other windows open.

     if (mainWindow === null) {
      createWindow()
     }
     })

    // In this file you can include the rest of your app's specific main process
    // code. You can also put them in separate files and require them here. `
    


4.	打包成exe文件
npm install electron --save-dev安装electron。
安装完成后，文件夹中会多出一个文件夹node_modules。

- 输入npm install electron-packager -g安装electron-package。
修改package.json。
在"scripts"中加入"packager"配置：
`"packager": "electron-packager ./ Myexe --platform=all --arch=x64 --electron-version=1.0.0 --out=../text --overwrite"`

./表示当前路径
Myexe ：exe应用的名称
platform: 打包平台 darwin, linux, mas, win32或者选择all
arch: 可选 ia32, x64, armv7l, arm64或者选择all
electron-version： electron的版本（）
out：生成的exe保存目录
overwrite:使用了这个参数，每次打包就不用把原来exe删除，可直接覆盖了。

- 使用命令 npm run-script packager进行打包时出现错误
 先输入npm cache clean --force命令清除npm缓存 
- 输入npm install重装npm
- npm run-script packager打包文件

## 运行环境

## 功能描述
## 源代码文件说明
