'use strict';

/**
 * @ngdoc overview
 * @name weatherAppFrontendApp
 * @description
 * # weatherAppFrontendApp
 *
 * Main module of the application.
 */
angular
  .module('weatherAppFrontendApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'weatherApp.controllers',
    'weatherApp.services'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'features/views/weather5Day.html',
        controller: 'weatherCtrl'
      })
      .when('/weather3hr',{
        templateUrl: 'features/views/weather3hr.html',
        controller: 'weatherCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  })

  .controller('HeaderCtrl', function($scope, $location){
    $scope.isActive = function(viewLocation){
      return viewLocation === $location.path();
      console.log(viewLocation)
    }
  });
