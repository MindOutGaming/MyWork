/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validateForm() {
    // validate
    var result = validate_empty('username', 'Username') &&
            validate_empty('password', 'Password');

    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    if (result) {
        ajaxCall('POST', 'home.fin', 'username=' + username + '&password=' + password, 'ajax');

        // read hidden value
        var status = document.getElementById('ajax').value;

        if (status > 0) {
            window.location.href = "dashboard.jsp";
        } else {
            alert("Username or Password is invalid!");
        }
    }

    return false;
}
// validation functions
function validate_empty(elementId, label) {
    var value = document.getElementById(elementId).value;

    if (value === '') {
        alert(label + " is required and cannot be empty!");
        document.getElementById(elementId).focus();
        return false;
    }
    return true;
}

// ajax
function ajaxCall(method, url, data, destination, isHtml) {
    var xhttp = new XMLHttpRequest();
    // event
    xhttp.onload = function () {
        if (isHtml) {
            document.getElementById(destination).innerHTML = this.responseText;
        } else {
            document.getElementById(destination).value = this.responseText;
        }
    };

    xhttp.open(method, url, false);
    xhttp.setRequestHeader('content-type', 'application/x-www-form-urlencoded');

    xhttp.send(data);
}
function logoutUser() {
    var res = confirm('Are you sure, you want to logout?');

    if (res) {
        ajaxCall('POST', 'logout.fin', '', 'ajax');

        window.location.href = "index.jsp";
    }
}
function StudentsLoader() {
    // ajax call
    ajaxCall('POST', 'students.fin', 'process=load', 'ajax', 'html');
}
function ViewStudentsLoader(param) {
    // ajax call
    ajaxCall('POST', 'processStudents.fin', 'process='+param, 'studentload', 'html');
}
function AddStudentsLoader() {
    // ajax call
    ajaxCall('POST', 'processStudents.fin', 'process=addstudents', 'studentload', 'html');
}
function ValidateStudentForm() {
    var result = validate_empty('name', 'Name')
            && validate_empty('address', 'Address')
            && validate_empty('email', 'Email Address')
            && validate_empty('state', 'State')
            && validate_empty('city', 'City');

    // if the result is true, then go for insert into db.
    var name = document.getElementById('name').value;
    var address = document.getElementById('address').value;
    var email = document.getElementById('email').value;
    var state = document.getElementById('state').value;
    var city = document.getElementById('city').value;

    if (result) {
        var data = "name=" + name + "&address=" + address + "&email=" + email + "&state=" + state + "&city=" + city + "&process=insertStudents";
        ajaxCall('POST', 'processStudents.fin', data, 'processAjax', 'html');

        // read hidden value
        var status = document.getElementById('status').value;
        if (status > 0) {
            alert("Student added successfully!");
            // ajaxCall('POST', 'processStudents.fin', 'process=addstudents', 'studentload', 'html');
            resetForm(document.getElementById('studentform'));
        } else {
            alert("Problem in record insertion");
        }

        // else prevent the form from submitting.
        return false;
    }
}
function resetForm(formObj) {
    formObj.reset();
}