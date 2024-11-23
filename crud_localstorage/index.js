var arr = [];

var count = 0;

//add data localstorage
function formSubmit() {
  var result =
    emtyValid("name", "nameError", "Name") &&
    emtyValid("email", "emailError", "Email") &&
    emtyValid("pnumber", "phoneError", "Phone Number") &&
    emtyValid("Address", "addressError", "Address") &&
    selectValid("hobby", "hobbyError") &&
    checkValid("check1", "check2", "lanError");
  if (result) {
    var result1 =
      emailValid("email", "emailError") && phoneValid("pnumber", "phoneError");
    if (result1) {
      var name = document.getElementById("name").value;
      var email = document.getElementById("email").value;
      var number = document.getElementById("pnumber").value;
      var address = document.getElementById("Address").value;
      var hobby = document.getElementById("hobby").value;
      var gender;
      var language = [];
      var genderEle = document.getElementsByName("gender");

      for (i = 0; i < genderEle.length; i++) {
        if (genderEle[i].checked) gender = genderEle[i].value;
      }

      var languageEle = document.getElementsByName("language");

      for (i = 0; i < languageEle.length; i++) {
        if (languageEle[i].checked) {
            language.push(languageEle[i].value);
        }
      }

      var obj = new FormData(
        name,
        email,
        number,
        address,
        hobby,
        gender,
        language
      );

if (localStorage.key("arrayKey")){
// alert("yes");
var a = JSON.parse(localStorage.getItem("arrayKey"));
a[Object.keys(a).length] = obj;
// console.log(Object.keys(a).length);
localStorage.setItem("arrayKey", JSON.stringify(a));

}else{
      arr.push(obj);
      localStorage.setItem("arrayKey", JSON.stringify(arr));
}
    location.reload();
      buttonStyle();

   


count = count +1
      document.getElementById("formId").reset();
    }
  }
  return false;
}

//show localstorage data
function showData(objs) {
  var tbody = document.getElementById("tbody");

  // var objs = ;
  for (let i = 0; i < objs.length; i++) {
    var tr = document.createElement("tr");
    var editbutton = document.createElement("button");
    var EbuttonText = document.createTextNode("Edit");
    var deletebutton = document.createElement("button");
    var dbuttonText = document.createTextNode("delete");
    editbutton.appendChild(EbuttonText);
    deletebutton.appendChild(dbuttonText);

    // console.log(Object.keys(objs[i]).length);

    for (let j = 0; j < Object.keys(objs[i]).length + 1; j++) {
      var td = document.createElement("td");
      var node = document.createTextNode(
        Object.values(objs[i])[j] == undefined ? "" : Object.values(objs[i])[j]
      );
      td.appendChild(node);
      td.appendChild(editbutton);
      td.appendChild(deletebutton);
      tr.append(td);
      tbody.append(tr);
    }

    deletebutton.addEventListener("click", function () {
      deleteData(i);
    });

    editbutton.addEventListener("click", function () {
      getEditdata(i);
    });

    buttonStyle();


  }


  
}

//get data for update
function getEditdata(id) {
  var eobj = JSON.parse(localStorage.getItem("arrayKey"));
  // console.log(Object.values(eobj[i]).length);
  // console.log(eobj[i].name);
  var Ename = eobj[id].name;
  var Eemail = eobj[id].email;
  var Enumber = eobj[id].number;
  var Eaddress = eobj[id].address;
  var Ehobby = eobj[id].hobby;
  var Egender = eobj[id].gender;
  var Elanguage = eobj[id].language;

  var name = document.getElementById("name");
  var email = document.getElementById("email");
  var number = document.getElementById("pnumber");
  var address = document.getElementById("Address");
  var hobby = document.getElementById("hobby");
  var male = document.getElementById("male");
  var female = document.getElementById("female");
  var check1 = document.getElementById("check1");
  var check2 = document.getElementById("check2");

  if (Egender == "Female") {
    female.checked = "checked";
  } else {
    male.checked = "checked";
  }

  
  for (var i of Elanguage) {
    if (i == "English") {
      check1.checked = "checked";
    } else if (i == "Gujarati") {
      check2.checked = "checked";
    }
  }

  name.value = Ename;
  email.value = Eemail;
  number.value = Enumber;
  address.value = Eaddress;
  hobby.value = Ehobby;

  document.getElementById("submit").style.display="none";;
  document.getElementById("update").style.display="block";;
  
  document.getElementById("update").addEventListener("click", function (event) {
    updateFormData(id);
    event.preventDefault();
  });
}

//update form
function updateFormData(id) {
//   alert(id);
  var result =
    emtyValid("name", "nameError", "Name") &&
    emtyValid("email", "emailError", "Email") &&
    emtyValid("pnumber", "phoneError", "Phone Number") &&
    emtyValid("Address", "addressError", "Address") &&
    selectValid("hobby", "hobbyError") &&
    checkValid("check1", "check2", "lanError");
  if (result) {
    var uobj = JSON.parse(localStorage.getItem("arrayKey"));
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var number = document.getElementById("pnumber").value;
    var address = document.getElementById("Address").value;
    var hobby = document.getElementById("hobby").value;

    var gender;
    var language = [];
    var genderEle = document.getElementsByName("gender");

    for (i = 0; i < genderEle.length; i++) {
      if (genderEle[i].checked) gender = genderEle[i].value;
    }

    var languageEle = document.getElementsByName("language");

    for (i = 0; i < languageEle.length; i++) {
      if (languageEle[i].checked) {
          language.push(languageEle[i].value);
      }
    }

    uobj[id].name = name;
    uobj[id].email = email;
    uobj[id].number = number;
    uobj[id].address = address;
    uobj[id].hobby = hobby;
    uobj[id].gender = gender;
    uobj[id].language = language;

    localStorage.setItem("arrayKey", JSON.stringify(uobj));

    document.getElementById("submit").style.display="block";
  document.getElementById("update").style.display="none";

  location.reload();

 
  }

  return false;
}

//delete table data
function deleteData(i) {
  var auth = confirm("Are you sure");
  if (auth) {
    var dobj = JSON.parse(localStorage.getItem("arrayKey"));

    dobj.splice(i, 1);

    localStorage.setItem("arrayKey", JSON.stringify(dobj));

    location.reload();

    buttonStyle();
  }
}

//form data object
function FormData(name, email, number, address, hobby, gender, language) {
  this.name = name;
  this.email = email;
  this.number = number;
  this.address = address;
  this.hobby = hobby;
  this.gender = gender;
  this.language = language;
}

//sorting data
function thShorting(element){
 
    var thname = element.getAttribute("headName");
   var mainobj =  JSON.parse(localStorage.getItem("arrayKey"));
   var text = element.innerHTML;
    text = text.substring(0,text.length-1);    
    var order = element.getAttribute("headOrder");



if(element.previousElementSibling ==null){
  var pre= "";
}else{
  var pre= element.previousElementSibling.innerHTML;
}

// if(element.nextElementSibling==null){
// var nex = "";
// }else{
  var nex = element.nextElementSibling.innerHTML;

// }


if(order=="asc"){
  text +='&#8593;'; 
  element.innerHTML= text;
  element.setAttribute("headOrder","desc");
  
if (nex.includes('↑') ||nex.includes('↓')){
  element.nextElementSibling.innerHTML=nex.substring(0,nex.length-1);
} else if(pre.includes('↑') ||pre.includes('↓')){
  element.previousElementSibling.innerHTML=pre.substring(0,pre.length-1);
}


mainobj.sort(function(a,b){
  // alert(a[thname]);
  // alert(b[thname]);

  if(a[thname]<b[thname]){
   return -1;
  }else{
    return 1;
  }

});

var tbody = document.getElementById("tbody");
while (tbody.firstChild) {
  tbody.removeChild(tbody.lastChild);
}

showData(mainobj);



}else {
  text +='&#8595;'; 
  element.innerHTML= text;
  element.setAttribute("headOrder","asc");

  if (nex.includes('↑') ||nex.includes('↓')){
    element.nextElementSibling.innerHTML=nex.substring(0,nex.length-1);
  } else if(pre.includes('↑') ||pre.includes('↓')){
    element.previousElementSibling.innerHTML=pre.substring(0,pre.length-1);
  }

  mainobj.sort(function(a,b){
  
    if(a[thname]>b[thname]){
     return -1;
    }else{
      return 1;
    }
  
  });

  var tbody = document.getElementById("tbody");
while (tbody.firstChild) {
  tbody.removeChild(tbody.lastChild);
}
  showData(mainobj);

  

}




}


// button style class
function buttonStyle() {
    const classbutton = document.getElementsByTagName("button");
    for (let i = 0; i < classbutton.length; i++) {
      classbutton[i].classList.add("btn", "btn-outline-primary");
    }
  }

//empty validation
function emtyValid(eleId, spanId, name) {
  var ele = document.getElementById(eleId).value;
  var span = document.getElementById(spanId);
  if (ele == "") {
    span.innerHTML = name + " is required";
    return false;
  } else {
    span.innerHTML = "";
    return true;
  }
}

//select validation
function selectValid(eleId, spanId) {
  var ele = document.getElementById(eleId).value;
  var span = document.getElementById(spanId);
  if (ele == "select-one") {
    span.innerHTML = "select right option";
    return false;
  } else {
    span.innerHTML = "";
    return true;
  }
}

//checkbox validation

function checkValid(eleId1, eleId2, spanId) {
  var ele1 = document.getElementById(eleId1);
  var ele2 = document.getElementById(eleId2);
  var span = document.getElementById(spanId);
  if (ele1.checked == false && ele2.checked == false) {
    span.innerHTML = "pls choose one language";
    return false;
  } else {
    span.innerHTML = "";
    return true;
  }
}

//mail validation

function emailValid(eleId, spanId) {
  var ele = document.getElementById(eleId).value;
  var span = document.getElementById(spanId);
  var validRegex =
    /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
  if (ele.match(validRegex)) {
    span.innerHTML = "";
    return true;
  } else {
    span.innerHTML = "pls enter valid email";
    return false;
  }
}

//phone number validation

function phoneValid(eleId, spanId) {
  var ele = document.getElementById(eleId).value;
  var span = document.getElementById(spanId);

  if (ele < 0 || ele.length < 10 || ele.length > 10) {
    span.innerHTML = "pls enter valid phone number";
    return false;
  } else {
    span.innerHTML = "";
    return true;
  }
}
