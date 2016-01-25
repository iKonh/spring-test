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
        app.controller('check', function ($scope) {
            $scope.select = function () {
                $scope.chk = !$scope.chk;
            };
        });
        app.controller('accountDataCtrl', function($scope, $http) {
            $http.get("data.json")
                    .success(function(response) {$scope.beans = response;});
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
    <div ng-controller="check">
        <button type="button" ng-click="select()">选择</button>
        <input type="checkbox" ng-model="chk"/>
    </div>
    <div class="box-body" ng-controller="accountDataCtrl">
        <table id="example" class="table table-bordered table-striped table-hover">
            <thead>
            <tr role="row" class="btn-primary">
                <th></th>
                <th>
                    <input type="checkbox">
                </th>
                <th>DM配信</th>
                <th>会員ID</th>
                <th>名前（漢字）</th>
                <th>名前（カナ）</th>
                <th>メールアドレス</th>
                <th>電話番号</th>
                <th>郵便番号</th>
                <th>都道府県</th>
                <th>住所</th>
                <th>生年月日</th>
                <th>登録日</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="bean in beans">
                <td>{{$index+1}}</td>
                <td>
                    <input type="checkbox">
                </td>
                <td>{{bean.dm}}</td>
                <td>{{bean.accountId}}</td>
                <td>{{bean.name}}</td>
                <td>{{bean.nameKana}}</td>
                <td><a href="#">{{bean.mail}}</a></td>
                <td>{{bean.phoneNo}}</td>
                <td>{{bean.postalcode}}</td>
                <td>{{bean.city}}</td>
                <td>{{bean.address}}</td>
                <td>{{bean.birth}}</td>
                <td>{{bean.create}}</td>
            </tr>
            </tbody>
            <tfoot>
            <tr class="btn-primary">
                <th></th>
                <th>
                    <input type="checkbox">
                </th>
                <th>DM配信</th>
                <th>会員ID</th>
                <th>名前（漢字）</th>
                <th>名前（カナ）</th>
                <th>メールアドレス</th>
                <th>電話番号</th>
                <th>郵便番号</th>
                <th>都道府県</th>
                <th>住所</th>
                <th>生年月日</th>
                <th>登録日</th>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
</body>
</html>
