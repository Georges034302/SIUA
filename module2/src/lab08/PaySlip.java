package lab08;


public class PaySlip{
    
    public static void main(String[] args){
        PaySlip p = new PaySlip();
        String name = p.readName();
        double income = p.readIncome();
        p.show(name, income);
    }
    
    //Goal 1: show the formatted table 
    private void show(String name, double income){  
        System.out.println("|---------------+-----------+-----------+------------+----------------|");
        System.out.println("| Employee      | Wages     | Taxes     | Net Pay    | SuperAnnuation |");
        System.out.println("|---------------+-----------+-----------+------------+----------------|");
        String output = String.format("| %-14s| %-10.2f| %-10.2f| %-10.2f | %-10.2f     |", name,income,tax(income),netIncome(income),superTax(income));
        System.out.println(output);
        System.out.println("|---------------+-----------+-----------+------------+----------------|");
    }
    
    //READ name and income
    private String readName(){
        System.out.print("Name: ");
        return In.nextLine();
    }
    
    private double readIncome(){
        System.out.print("Income: ");
        return In.nextDouble();
    }
    
    //Goal 2: Calculate the NET
    private double netIncome(double income){
        return income-superTax(income)-tax(income);
    }
    
    //Goal 3: Calculate the Super
    private double superTax(double income){
        return (income*10)/100;
    }
    
    //Goal 4: Calculate the TAX
    private double tax(double income){
        return (income > 180000)? (((income - 180000)* 0.45) + 51667): 
               (income > 120000 && income <= 180000)? (0.37 * (income - 120000)+29467): 
               (income > 45000 && income <= 120000)? ((income - 45000) * (32.5/100) + 5092): 
               (income > 18200 && income <= 45000)? ((income-18200)*0.19): 0;
    }    
}
