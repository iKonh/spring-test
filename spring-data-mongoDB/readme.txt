设置环境变量
添加MONGO_HOME mongo根目录
增加path %MONGO_HOME%\bin

执行如下安装mongo服务
mongod -dbpath %MONGO_HOME%\data\db  --logpath %MONGO_HOME%\log\mongodb.log  --install --serviceName MongoDB

控制台或者管理界面启动服务
net start MongoDB