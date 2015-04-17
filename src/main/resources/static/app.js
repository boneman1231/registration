// var mainModule = angular.module("MainModule", ['ui.bootstrap','mgcrea.ngStrap']);
var mainModule = angular.module("MainModule", ['ui.bootstrap']);

mainModule.controller("DateController",
  function($scope, $timeout, $filter) {
    $scope.formatPattern = 'yyyy/M/d';

    // initialze functions for date picker 
    $scope.dateOptions = {
      startingDay: 1,
      showWeeks: false
    };
    $scope.today = function() {
      $scope.targetDate = $filter('date')(new Date(), $scope.formatPattern);
    };
    $scope.open = function() {
      $timeout(function() {
        $scope.opened = true;
      });
    };

    // initial target date
    $scope.today();

    // return date string 
    $scope.dateString = function() {
      var dateObj = new Date($scope.targetDate);
      var yearString = dateObj.getFullYear().toString();
      var yearLastDigit = yearString.substr(yearString.length - 1);
      // yearLastDigit=$filter('limitTo')(dateObj.getFullYear(), 1,3);

	  var result = "W" + yearLastDigit + $filter('date')((dateObj), 'ww M/d (EEEE)');
	  	  
	  function getMonday(theDate) {
		theDate = new Date(theDate);
		var day = theDate.getDay(),
			diff = theDate.getDate() - day + (day == 0 ? -6:1); 
		return new Date(theDate.setDate(diff));
	  }
	  
	  var startDate = getMonday(dateObj);
	  var endDate = new Date(startDate).setDate(startDate.getDate()+4);
	  result = result + " ... " + $filter('date')((startDate), 'M/d (EEEE)')
				+ " - " + $filter('date')((endDate), 'M/d (EEEE)');
	  
      return result;
    }
  }
);

mainModule.controller("LayoutController",
  function($scope, $http, $filter) {

    this.days = null;
    this.timeSlots = null;
    this.headers = [];
    this.subHeaders = [];
    this.contentMap = {}

    // call http service for scope
    var mainModule = this;
    $http.get('scope.json').success(function(data) {
      mainModule.days = data.days;
      mainModule.timeSlots = data.timeSlots;
    });

    // call http service for layout //TODO REST service
    $http.get('layout.json').success(function(data) {
      angular.forEach(data.headers, function(header) {
        mainModule.headers.push(header);

        angular.forEach(header.targets, function(target) {
          // date plus target id
          target["id"] = header.date + "_" + target.id;
          mainModule.subHeaders.push(target);
        });
      });
    });

    // call http service for content //TODO REST service
	//var contentUrl = 'content.json';	
	var contentUrl = '/records';
    $http.get(contentUrl).success(function(data) {	  
      angular.forEach(data._embedded.records, function(record) {
		record.date = $filter('date')(new Date(record.date), 'yyyy-MM-dd');
        var id = record.date + "_" + record.targetId + "_" + record.timeSlot;		
        mainModule.contentMap[id]=record;
      });
    });
    
    $scope.showContent = function(id) {
      //return "11111111s";
      return $scope.contentMap[id].remark;
    };

  }
);

$('[data-toggle="popover"]').popover();

$('body').on('click', function (e) {
    $('[data-toggle="popover"]').each(function () {
        //the 'is' for buttons that trigger popups
        //the 'has' for icons within a button that triggers a popup
        if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
            $(this).popover('hide');
        }
    });
});