function valid(elementId,elementName){
  //var data = document.getElementById(elementId).value;
  var data = $(elementId).val();
  if(data==''){
    alert(elementName+" is required");
    return false;
    
  }
  return true;
}