class Myfun{
  public static void main (String[] args) {
    
    myrange(1,5,2);
    myrange(1,5);
  }
    
    public static void myrange(int start,int end,int increment){
      for(int i=start;i<=end;i+=increment){
        System.out.println(i);
      }
      
    }
    
    public static void myrange(int start,int end){
      for(int i=start;i<=end;i++){
        System.out.println(i);
      }
      
    }
  
}



//in the javascript 

function Myrange(start,end,increment=1){
  for(let i=start;i<=end;i+=increment){
    console.log(i);
  }
}

console.log(Myrange(1,5,2));
console.log("---------");
console.log(Myrange(1,5));

