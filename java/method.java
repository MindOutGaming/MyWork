class go {

  // create a method
  public int addNumbers(int a, int b) {
    int sum = a + b;
    // return value
    return sum;
  }

  public static void main(String[] args) {
    
    int num1 = 25;
    int num2 = 25;

    // create an object of Main
    
    go a = new go();
    // calling method
    int result = a.addNumbers(num1, num2);
    System.out.println("Sum is: " + result);
  }
}