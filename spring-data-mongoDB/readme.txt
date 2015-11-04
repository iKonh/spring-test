设置环境变量
添加MONGO_HOME mongo根目录
增加path %MONGO_HOME%\bin

执行如下安装mongo服务
mongod -dbpath {数据文件存储目录}  --logpath {log文件存储目录}  --install --serviceName MongoDB

控制台或者管理界面启动服务
net start MongoDB