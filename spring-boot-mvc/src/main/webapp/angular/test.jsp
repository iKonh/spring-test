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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-translate/2.6.1/angular-translate.js"></script>
    <script>
        var app = angular.module('myApp', ['pascalprecht.translate']);
        app.config(function ($translateProvider) {
            $translateProvider.translations('en', {
                BUTTON_LANG_EN: 'english',
                BUTTON_LANG_ZH: 'chinese'
            });
            $translateProvider.translations('zh', {
                BUTTON_LANG_EN: '英语',
                BUTTON_LANG_ZH: '中文'
            });
            $translateProvider.preferredLanguage('zh');
        });
        app.controller('customersCtrl', function($scope, $http) {
            $http.get("http://192.168.2.119:8080/test")
                    .success(function(response) {$scope.beans = response;});
        });
        app.controller('translate', function ($scope, $translate) {
            $scope.changeLanguage = function (key) {
                $translate.use(key);
            };
        });
    </script>
    <title></title>
</head>
<body>
<div ng-app="myApp">
    <div ng-controller="customersCtrl">
        <li ng-repeat="bean in beans">
            {{ bean.name + ', ' + bean.age }}
        </li>
    </div>
    <div ng-controller="translate">
        <button type="button" ng-click="changeLanguage('zh')" translate="BUTTON_LANG_ZH"></button>
        <button type="button" ng-click="changeLanguage('en')" translate="BUTTON_LANG_EN"></button>
    </div>
</div>
</body>
</html>
