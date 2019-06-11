var app = angular.module("StudentManagerment", []);
 
// Controller Part
app.controller("StudentController", function($scope, $http) {
 
 
    $scope.students = [];
    $scope.studentForm = {
    	idstudent: 1,
    	fullname: "",
        email: "",
        phone: "",
        classs: "",
        note: ""
    };
 
    // Now load the data from server
    _refreshEmployeeData();
    
 
    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitStudent = function() {
 
        var method = "";
        var url = "";
 
        if ($scope.studentForm.Id == -1) {
            method = "POST";
            url = '/student';
        } else {
            method = "PUT";
            url = '/student';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.studentForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createStudent = function() {
        _clearFormData();
    }
 
    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteStudent = function(student) {
        $http({
            method: 'DELETE',
            url: '/student/' + student.idstudent
        }).then(_success, _error);
    };
 
    // In case of edit
    $scope.editStudent = function(student) {
        $scope.studentForm.idstudent = student.idstudent;
        $scope.studentForm.fullname = student.fullname;
        $scope.studentForm.email = student.email;
        $scope.studentForm.phone = student.phone;
        $scope.studentForm.classs = student.classs;
        $scope.studentForm.note = student.note;
    };
 
    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/student'
        }).then(
            function(res) { // success
                $scope.students = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function _clearFormData() {
        $scope.studentForm.idstudent = -1;
        $scope.studentForm.fullname = "";
        $scope.studentForm.email = "";
        $scope.studentForm.phone = "";
        $scope.studentForm.classs = "";
        $scope.studentForm.note = ""
    };
});