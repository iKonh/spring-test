<%--
  Created by IntelliJ IDEA.
  User: Huangyipeng
  Date: 2015/11/23
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://apps.bdimg.com/libs/angular.js/1.3.9/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('customersCtrl', function($scope, $http) {
            $http.get("http://192.168.2.119:8080/test")
                    .success(function(response) {$scope.beans = response;});
        });
    </script>
    <title></title>
</head>
<body>
<div ng-app="myApp" ng-controller="customersCtrl">
    <li ng-repeat="bean in beans">
        {{ bean.name + ', ' + bean.age }}
    </li>
</div>
</body>
</html>
