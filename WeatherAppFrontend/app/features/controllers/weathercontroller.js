angular.module('weatherApp.controllers',[])

.controller('weatherCtrl',function($scope, $location, weatherservice){

	$scope.weatherForecastManagerEvery3Hours = [];
	$scope.weatherForecastManager5Days = [];

	$scope.$watch(function(){
		return weatherservice.getWeather();
	}, function(newVal, oldVal){
		console.log(newVal);
		if(newVal != undefined){
			$scope.rawData = newVal;
			console.log(newVal);
			$scope.parsedData = JSON.parse($scope.rawData);
			buildWeatherForecasts();
			console.log($scope.parsedData);
			
		}
	})

	function weatherForecast(temperature, humidity,forecast, forecastDesc, clouds, wind, date, time){
		this.temperature = temperature;
		this.humidity = humidity;
		this.forecast = forecast;
		this.forecastDesc = forecastDesc;
		this.clouds = clouds;
		this.wind = wind;
		this.date = date;
		this.time = time;
	}

	function buildWeatherForecasts(){
		var weatherData = $scope.parsedData.list;
		var myWeatherForecast;
		for(wf in weatherData){
		myWeatherForecast = new weatherForecast(
				Math.round(weatherData[wf].main.temp*9/5-459.67),
				weatherData[wf].main.humidity,
				weatherData[wf].weather[0].main,
				weatherData[wf].weather[0].description,
				weatherData[wf].clouds.all,
				Math.round(weatherData[wf].wind.speed*2.23694*10)/10,
				weatherData[wf].dt_txt.substring(5,10),
				weatherData[wf].dt_txt.substring(11)
			)
		$scope.weatherForecastManagerEvery3Hours.push(myWeatherForecast);
		if(myWeatherForecast.time == '12:00:00'){
			$scope.weatherForecastManager5Days.push(myWeatherForecast);
		}
		}
	console.log($scope.weatherForecastManagerEvery3Hours);
	console.log($scope.weatherForecastManager5Days);
	}

	$scope.isActive = function(viewLocation){
		return viewLocation === $location.path();
	}


})