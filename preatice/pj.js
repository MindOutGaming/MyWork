function valid(elementId, elementName){
  var result = document.getElementById(elementId);
  if (result.value===""){
    alert(elementName+ " is required!");
    result.focus();
    return false;
  }
  return true;
}


function register(){
  var result = valid("date","Date")&&valid("time","Time")&&valid("fname","First Name")&&valid("lname","Last Name")&&valid("address","Address")&&valid("email","Email")&&valid("contact","Contact")&&valid("dob","Date of Birth")&&valid("state","State")&&valid("city","City")&&valid("file","File");
  
  return false;
}