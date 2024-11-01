import java.util.Scanner;
class Consumer {
    String name;
    String member_type;
    
    void get() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter membership type: ");
        this.member_type = scanner.nextLine();
    }
    
    void show() {
        System.out.println("Name: " + this.name);
        System.out.println("Membership type: " + this.member_type);
    }
}

class BillIssue extends Consumer {
    double bill_amount;
    
    void get() {
        super.get();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bill amount: ");
        this.bill_amount = scanner.nextDouble();
    }
    
    void show() {
        super.show();
        System.out.println("Bill amount: " + this.bill_amount);
    }
}

class BillDiscount extends BillIssue {
    void show() {
        super.show();
        double discount_percent = 0;
        if (this.member_type.equals("gold")) {
            discount_percent = 10;
        } else if (this.member_type.equals("platinum")) {
            discount_percent = 20;
        } else if (this.member_type.equals("silver")) {
            discount_percent = 5;
        }
        
        double discount_amount = this.bill_amount * (discount_percent / 100);
        double net_amount = this.bill_amount - discount_amount;
        
        System.out.println("Discount amount: " + discount_amount);
        System.out.println("Net amount: " + net_amount);
    }
}
