设置环境变量
增加path mongodb目录中bin文件夹下

执行如下安装mongo服务
mongod -dbpath {数据文件存储目录}  --logpath {log文件存储目录}  --install --serviceName MongoDB

控制台或者管理界面启动服务
net start MongoDB

添加用户(3.0以后版本)
db.createUser(
   {
     user: "temp",
     pwd: "temp",
     roles: [ "readWrite", "dbAdmin" ]
   }
)
db.auth("temp","temp")