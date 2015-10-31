angular.module('weatherApp.services',[])

.factory('weatherservice',function($http){
	var weatherObject = undefined;
	function getDataFromMysql(){
		$http({
			method: 'GET',
			url: 'http://127.0.0.1:8080/getData',
		}).then(function(response){
			console.log(response);
			weatherObject = response.data.json;
		})}
		getDataFromMysql();
		return{
			getWeather: function() { return weatherObject; }
	}
})