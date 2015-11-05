设置环境变量
增加path mongodb目录中bin文件夹下

执行如下安装mongo服务(无用户认证)
mongod -dbpath {数据文件存储目录}  --logpath {log文件存储目录}  --install --serviceName MongoDB

控制台或者管理界面启动服务
net start MongoDB

添加用户(3.0以后版本)
>db.createUser( { "user" : "accountAdmin03",
                 "pwd": "admin",
                 "customData" : { employeeId: 12345 },
                 "roles" : [ { role: "clusterAdmin", db: "admin" },
                             { role: "readAnyDatabase", db: "admin" },
                             "readWrite"
                             ] },
               { w: "majority" , wtimeout: 5000 } )

添加用户认证(不设置无法远程认证用户)
>use admin
>var schema = db.system.version.findOne({"_id" : "authSchema"})
>schema.currentVersion = 3
>db.system.version.save(schema)

停止服务后，重装mongo服务(有用户认证)
mongod  --auth --dbpath {数据文件存储目录}  --logpath {log文件存储目录}  --reinstall --serviceName MongoDB

用户登录
mongo -u accountAdmin03 -p admin --authenticationDatabase test