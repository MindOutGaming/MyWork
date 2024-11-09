let counter = 0;

function classstyle() {
    const classli = document.getElementsByTagName("li");
    for (let i = 0; i < classli.length; i++) {
        classli[i].classList.add("list-group-item");
    }

    const classbutton = document.getElementsByTagName("button");
    for (let i = 0; i < classbutton.length; i++) {
        classbutton[i].classList.add("btn", "btn-outline-primary");
    }

}

//  function newPerentUser() {
//     counter = counter + 1;
//     var perentUl = document.getElementById("perentUl");
// //
//     // var perentChildLi = document.createElement("li");
//     // var liText = document.createTextNode(`User ${counter}`);
//     // var plusebutton = document.createElement("button");
//     // var pbuttonText = document.createTextNode("+");
//     // var mbutton = document.createElement("button");
//     // var mbuttonText = document.createTextNode("-");
//     // plusebutton.appendChild(pbuttonText);
//     // mbutton.appendChild(mbuttonText);
//     // perentChildLi.appendChild(plusebutton);
//     // perentChildLi.appendChild(liText);
//     // perentChildLi.appendChild(mbutton);
// //

 

//     perentUl.append(perentChildLi);

//     plusebutton.addEventListener('click', function () { ChildUl(this) });
    
//     mbutton.addEventListener('click',function(){removeChild(this)});

//     classstyle();

    
// }


 function ChildUl(ele) {
    counter = counter + 1;
    // alert(ele.parentElement.nodeName.childNodes.length);
    var buttonperent = ele.parentElement;
    var allChilds = buttonperent.children;

    var ChildLi = document.createElement("li");
    var liText = document.createTextNode(`User ${counter}`);
    var plusebutton = document.createElement("button");
    var pbuttonText = document.createTextNode("+");
    var mbutton = document.createElement("button");
    var mbuttonText = document.createTextNode("-");
    plusebutton.appendChild(pbuttonText);
    mbutton.appendChild(mbuttonText);

    ChildLi.appendChild(plusebutton);
    ChildLi.appendChild(liText);
    ChildLi.appendChild(mbutton);

    if (allChilds[allChilds.length - 1].tagName == "UL") {


        allChilds[allChilds.length - 1].append(ChildLi);


    } else {

        var newul = document.createElement("ul");
      
        newul.append(ChildLi);
        buttonperent.append(newul);

    }


    plusebutton.addEventListener('click', function () { ChildUl(this) });

    mbutton.addEventListener('click',function(){ removeChild(this)});
    
    classstyle();
}

function removeChild(ele){
ele.parentElement.remove();
}